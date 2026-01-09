package com.example.bank_sampah.controller;

import com.example.bank_sampah.model.WasteItem;
import com.example.bank_sampah.repository.WasteItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/waste")
public class WasteController {
    @Autowired
    private WasteItemRepository wasteRepository;

    // READ: Menampilkan List
    @GetMapping
    public String index(Model model) {
        model.addAttribute("wastes", wasteRepository.findAll());
        return "waste/index";
    }

    // CREATE: Form Tambah
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("waste", new WasteItem());
        return "waste/form";
    }

    // UPDATE: Form Edit
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        WasteItem waste = wasteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
        model.addAttribute("waste", waste);
        return "waste/form";
    }

    // POST: Simpan (Tambah/Edit)
    @PostMapping("/save")
    public String save(@ModelAttribute WasteItem waste) {
        if (waste.getId() != null && waste.getId().trim().isEmpty()) {
            waste.setId(null);
        }
        
        wasteRepository.save(waste);
        return "redirect:/waste";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        wasteRepository.deleteById(id);
        return "redirect:/waste";
    }
}
