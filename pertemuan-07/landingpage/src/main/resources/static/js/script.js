// ============== TYPING ANIMATION ==============
const options = {
  strings: ["Developer", "Designer", "Tech Enthusiast", "Problem Solver"],
  typeSpeed: 100,
  backSpeed: 50,
  backDelay: 1500,
  loop: true,
  loopCount: Infinity,
};

const typed = new Typed("#typing", options);

// ============== AOS INITIALIZATION ==============
AOS.init({
  duration: 1000,
  offset: 100,
  easing: "ease-in-out",
  once: false,
});

// ============== NAVBAR INTERACTIVE ==============
const hamburger = document.querySelector(".hamburger");
const navMenu = document.querySelector(".nav-menu");
const navLinks = document.querySelectorAll(".nav-link");
const navbar = document.querySelector(".navbar");

// Toggle mobile menu
hamburger.addEventListener("click", () => {
  hamburger.classList.toggle("active");
  navMenu.classList.toggle("active");
});

// Close menu when nav link is clicked
navLinks.forEach((link) => {
  link.addEventListener("click", () => {
    hamburger.classList.remove("active");
    navMenu.classList.remove("active");
  });
});

// ============== NAVBAR SCROLL EFFECT ==============
window.addEventListener("scroll", () => {
  if (window.scrollY > 50) {
    navbar.classList.add("scroll-active");
  } else {
    navbar.classList.remove("scroll-active");
  }

  // Update active nav link
  updateActiveNavLink();
});

function updateActiveNavLink() {
  let current = "";
  const sections = document.querySelectorAll("section");

  sections.forEach((section) => {
    const sectionTop = section.offsetTop;
    if (scrollY >= sectionTop - 200) {
      current = section.getAttribute("id");
    }
  });

  navLinks.forEach((link) => {
    link.classList.remove("active");
    if (link.getAttribute("href").slice(1) === current) {
      link.classList.add("active");
    }
  });
}

// ============== STARS ANIMATION ==============
function createStars() {
  const starsContainer = document.querySelector(".stars");
  const starCount = 50;

  for (let i = 0; i < starCount; i++) {
    const star = document.createElement("div");
    star.className = "star";
    star.style.left = Math.random() * 100 + "%";
    star.style.top = Math.random() * 100 + "%";
    star.style.animationDelay = Math.random() * 3 + "s";
    starsContainer.appendChild(star);
  }
}

createStars();

// ============== SKILL BARS ANIMATION ==============
const observerOptions = {
  threshold: 0.5,
};

const observer = new IntersectionObserver((entries) => {
  entries.forEach((entry) => {
    if (entry.isIntersecting) {
      const progressFills = entry.target.querySelectorAll(".progress-fill");
      progressFills.forEach((fill) => {
        const width = fill.style.width;
        fill.style.width = "0";
        setTimeout(() => {
          fill.style.width = width;
        }, 100);
      });
      observer.unobserve(entry.target);
    }
  });
}, observerOptions);

const skillsSection = document.querySelector(".skills");
if (skillsSection) {
  observer.observe(skillsSection);
}

// ============== FORM HANDLING ==============
const contactForm = document.querySelector(".contact-form");
if (contactForm) {
  contactForm.addEventListener("submit", (e) => {
    e.preventDefault();

    // Get form data
    const data = {
      name: contactForm.querySelector('input[type="text"]').value,
      email: contactForm.querySelector('input[type="email"]').value,
      message: contactForm.querySelector("textarea").value,
    };

    // Simulate form submission
    console.log("Form submitted:", data);
    alert("Terima kasih! Pesan Anda telah dikirim.");

    // Reset form
    contactForm.reset();
  });
}

// ============== SMOOTH SCROLL FOR BUTTONS ==============
const smoothScrollButtons = document.querySelectorAll(
  '[onclick*="scrollIntoView"]'
);
smoothScrollButtons.forEach((button) => {
  button.addEventListener("click", (e) => {
    e.preventDefault();
  });
});

// ============== PAGE LOAD ANIMATION ==============
window.addEventListener("load", () => {
  document.body.style.opacity = "1";
});

// ============== LAZY LOADING IMAGES ==============
const images = document.querySelectorAll("img");
const imageObserver = new IntersectionObserver((entries, observer) => {
  entries.forEach((entry) => {
    if (entry.isIntersecting) {
      const img = entry.target;
      img.style.animation = "fadeIn 0.5s ease-in";
      observer.unobserve(img);
    }
  });
});

images.forEach((img) => imageObserver.observe(img));

// ============== SCROLL TO TOP BUTTON ==============
const scrollTopBtn = document.createElement("button");
scrollTopBtn.innerHTML = '<i class="fas fa-arrow-up"></i>';
scrollTopBtn.className = "scroll-top-btn";
scrollTopBtn.style.cssText = `
    position: fixed;
    bottom: 30px;
    right: 30px;
    width: 50px;
    height: 50px;
    border-radius: 50%;
    background: linear-gradient(135deg, #6366f1, #8b5cf6);
    border: none;
    color: white;
    cursor: pointer;
    z-index: 999;
    opacity: 0;
    visibility: hidden;
    transition: all 0.3s ease;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 1.2rem;
`;

document.body.appendChild(scrollTopBtn);

window.addEventListener("scroll", () => {
  if (window.scrollY > 500) {
    scrollTopBtn.style.opacity = "1";
    scrollTopBtn.style.visibility = "visible";
  } else {
    scrollTopBtn.style.opacity = "0";
    scrollTopBtn.style.visibility = "hidden";
  }
});

scrollTopBtn.addEventListener("click", () => {
  window.scrollTo({
    top: 0,
    behavior: "smooth",
  });
});

// ============== CONSOLE MESSAGE ==============
console.log(
  "%c🎉 Welcome to My Portfolio!",
  "color: #6366f1; font-size: 20px; font-weight: bold;"
);
console.log(
  "%cMade with ❤️ using Spring Boot & Modern Web Technologies",
  "color: #8b5cf6; font-size: 14px;"
);
