public class DatabaseDemo {
    // # Database

    // Structured Database -> tabel (berisi baris dan kolom, yang tiap kolom nya merepresentasikan suatu data)
    // Semi Structured Database -> file JSON (berisi object dengan masing-masing data nya saling berpasangan key, value)
    // Unstructured Database -> data mentah / informasi umum yang biasa kita temui sehari hari

    // SQL dan NoSQL
    // Database SQL berbasis tabel dan menggunakan struktur data terstruktur dengan skema yang telah ditentukan sebelumnya. (cth: MySQL, PostgreSQL, dan Oracle)
    // Database NoSQL lebih fleksibel dan dapat menyimpan data dalam format yang cukup beragam seperti dokumen (MongoDB), key-value (Redis), graf (Neo4j), atau kolom lebar (Cassandra)

    // SQL memiliki skema tetap dimana struktur tabel harus ditentukan sebelumnya. Perubahan pada skema akan memerlukan migrasi data.
    // NoSQL tidak memiliki skema tetap, memungkinkan penyimpanan data yang tidak terstruktur atau semi-terstruktur, dan mudah menyesuaikan struktur data seiring perubahan kebutuhan

    // SQL cocok untuk aplikasi yang di mana integritas data dan transaksi yang kompleks, seperti sistem perbankan, dan lainnya.
    // NoSQL cocok untuk aplikasi dengan data yang berubah cepat dan tidak terstruktur seperti media sosial, analisis real-time, dan aplikasi big data.

    // SQL menggunakan bahasa kueri SQL standar untuk mengakses dan memanipulasi data nya.
    // Setiap Jenis NoSQL mungkin memiliki metode sendiri untuk kueri data, dan tidak menggunakan SQL standar.

    // Database berbasis dokumen adalah jenis basis data NoSQL yang dirancang untuk menyimpan, mengambil, dan mengelola data terstruktur atau semi-terstruktur dalam format dokumen.
    // Setiap dokumen adalah unit independen yang menyimpan data dalam format seperti JSON, BSON, XML, atau YAML

    // Dokumen -> merupakan unit penyimpanan utama yang menyimpan berbagai tipe data seperti string, angka, list, ataupun object bersarang. Dokumen-dokumen ini biasanya menggunakan format JSON atau BSON.
    // Collection -> Dokumen biasanya dikelompojjan dalam Collection. Collection sendiri merupakan kumpulan dokumen yang saling terkait atau mirip, mirip dalam tabel dalam basis data relasional, tetapi tanpa skema tetap.
    // Indeks -> Database berbasis dokumen mendukung pembuatan indeks untuk mempercepat pencarian data. Indeks dapat dibuat berdasarkan satu atau beberapa field dalam dokumen
    /*
        Database (bungkusan terluar)
        Collection (pembungkus dokumen)
        Document (bungkusan terakhir dalam hirarki NoSQL)
    */

    // Langkah Instalasi MongoDB
    // Download MongoDB di situs resminya, kemudian download versi Community Server yang sesuai dengan OS kita
    // Ikuti petunjuk instalasi yang diberikan oleh installler
    // Setelah instalasi, tambahkan direktori bin MongoDB (biasanya C:\Program Files\MongoDB\Server\<versi>\bin di windows) ke dalam PATH sistem agar kita bisa menjalankan perintah MongoDB dari command line

    // Menjalankan MongoDB
    // Buka terminal atau command prompt, lalu jalankan perintah mongosh untuk mengakses shell MongoDB

    // Membuat Database baru
    // Untuk membuat / menggunakan database yang sudah ada, bisa dengan menggunakan perintah "use <nama database>"

    // Membuat Collection baru
    // Untuk membuat collection baru, bisa dengan perintah:
    // db.createCollection("<nama collection>")

    // Menambahkan dokumen JSON ke dalam koleksi (Create)
    /* 
        db.<nama collection>.insertOne({
            name: "Ridwan",
            age: 21,
            address: {
                street: "value",
                city: "value",
                country: "value",
            }
        }) 
    */

    // Menampilkan dokumen dalam Collection (Read)
    // db.<nama collection>.find().pretty()

    // Melakukan perubahan data pada dokumen Collection (Update)
    /*
        db.<nama collection>.updateOne(
            // inisiasi data pada id mana yang akan diubah
            { _id: ObjectId("691fda19aca7602cc263b112") },
            {
                // inisiasi data mana saja yang akan diubah
                $set: {
                    age: 22,
                    // jika data yang akan diubah bertipe object, bisa dituliskan seperti contoh berikut
                    "address.city": "Cimahi"
                }
            }
        )
    */

    // Menghapus data dokumen pada collection (Delete)
    // db.<nama collection>.deleteOne({ _id: "691fda19aca7602cc263b112" })

    // Menghapus data dokumen berdasarkan kata kunci
    // db.<nama collection>.deleteMany({ key: "value" })
    // contoh: db.mycollection.deleteMany({ nama: "Ridwan" })
    // nah tapi delete yang satu ini mempunyai kelemahan karena kita menghapus data berdasarkan value, nantinya data lain pun yang mempunyai nilai yang sama akan ikut terdampak
}