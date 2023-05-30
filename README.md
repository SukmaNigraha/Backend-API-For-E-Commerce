# Backend-API-For-E-Commerce
Backend API untuk aplikasi e-commerce sederhana , API ini bertujuan untuk mengakses dan memanipulasi data setiap entitas dari database

### I Putu Gung Sukma Nigraha
2205551119

## About
Program ini bertujuan untuk membuat backend API untuk aplikasi e-commerce sederhana yang nantinya memberikan response dengan format JSON. Adapun request method pada API memuat: <br/>
**GET** untuk mendapatkan list atau detail data dari entitas. <br/>
**POST** untuk membuat data entitas baru. <br/>
**PUT** untuk mengubah data dari entitas. <br/>
**DELETE** untuk menghapus data dari entitas. <br/>

Data-data yang digunakan dalam aplikasi e-Commerce ini akan disimpan pada **database SQLite** yang kemudian akan dilakukan suatu pengujian API yang telah diprogram melalui aplikasi **Postman**

## Spesifikasi API dalam Aplikasi e-Commerce 
### **GET**

- GET /users untuk mendapatkan daftar semua user yang termuat di dalam database. 
<br/>

**http://localhost:8119/users**

[

    {
        "firstName": "Sukma",
        "lastName": "Nigraha",
        "addresses": [],
        "phoneNumber": "082147309044",
        "id": 1,
        "type": "Buyer",
        "email": "sukma@gmail.com"
    },
    {
        "firstName": "Cindu",
        "lastName": "Wedana",
        "addresses": [],
        "phoneNumber": "085212635652",
        "id": 2,
        "type": "Seller",
        "email": "cindu@gmail.com"
    },
    {
        "firstName": "Adit",
        "lastName": "Suarken",
        "addresses": [],
        "phoneNumber": "082873489683",
        "id": 3,
        "type": "Seller",
        "email": "adit@gmail.com"
    },
    {
        "firstName": "diva",
        "lastName": "Indrayana",
        "addresses": [],
        "phoneNumber": "084293820801",
        "id": 4,
        "type": "Seller",
        "email": "diva@gmail.com"
    },
    {
        "firstName": "Rama",
        "lastName": "Putra",
        "addresses": [],
        "phoneNumber": "087652365112",
        "id": 5,
        "type": "Buyer",
        "email": "rama@gmail.com"
    }
]

<br/>

- GET /users/1 untuk mendapatkan informasi user dan alamatnya. 
<br/>

**http://localhost:8119/users/1**
[

    {
        "firstName": "Sukma",
        "lastName": "Nigraha",
        "addresses": [
            {
                "province": "Bali",
                "city": "Denpasar",
                "postcode": "8003"
            }
        ],
        "phoneNumber": "082147309044",
        "id": 1,
        "type": "Buyer",
        "email": "sukma@gmail.com"
    }
]

<br/>

- GET /users/2/products untuk mendapatkan daftar produk milik user. 
<br/>
**http://localhost:8119/users/2/products**

[

    {
        "seller": 2,
        "price": "75000",
        "description": "kemeja dengan garis putih",
        "id": 1,
        "title": "Kemeja",
        "stock": 50
    },
    {
        "seller": 2,
        "price": "75000",
        "description": "Kemeja kotak kotak berwana hitam",
        "id": 4,
        "title": "Kemeja Flanel",
        "stock": 55
    }
]

<br/>

- GET /users/1/orders untuk mendapatkan daftar order milik user.
 <br/>

**http://localhost:8119/users/1/orders**
[

    {
        "note": 2,
        "total": 150000,
        "discount": 0,
        "id": 1,
        "is_paid": "1",
        "buyer": 1
    }
]

<br/>

- GET /users/1/reviews untuk mendapatkan daftar review yang dibuat oleh user.
 <br/>

**http://localhost:8119/users/1/reviews**
[

    {
        "nama": "Sukma",
        "star": 5,
        "description": "kemeja nya sangat keren",
        "order": 1
    }
]

<br/>

- GET /orders/1 untuk mendapatkan informasi order, buyer, detail order, review, product title, beserta pricenya. 
<br/>

**http://localhost:8119/orders/1**
[

    {
        "note": 2,
        "total": 150000,
        "reviews": [
            {
                "star": 5,
                "description": "kemeja nya sangat keren"
            }
        ],
        "discount": 0,
        "id": 1,
        "is_paid": "1",
        "order_detail": [
            {
                "product": "Kemeja",
                "quantity": 2,
                "price": 75000
            }
        ],
        "buyer": 1
    }
]

<br/>

- GET /products untuk mendapatkan daftar semua produk.
 <br/>

**http://localhost:8119/products**
[

    {
        "seller": 2,
        "price": "75000",
        "description": "kemeja dengan garis putih",
        "id": 1,
        "title": "Kemeja",
        "stock": 50
    },
    {
        "seller": 3,
        "price": "50000",
        "description": "Baju kaos berwarna hitam",
        "id": 2,
        "title": "Baju kaos",
        "stock": 58
    },
    {
        "seller": 4,
        "price": "65000",
        "description": "Celana pendek hitam",
        "id": 3,
        "title": "Celana",
        "stock": 30
    },
    {
        "seller": 2,
        "price": "75000",
        "description": "Kemeja kotak kotak berwana hitam",
        "id": 4,
        "title": "Kemeja Flanel",
        "stock": 55
    },
    {
        "seller": 3,
        "price": "70000",
        "description": "Baju lengan panjang yang menutupi leher",
        "id": 5,
        "title": "Baju turtle neck",
        "stock": 35
    }
]
<br/>

- GET /products/1 untuk mendapatkan informasi produk dan seller. 
<br/>

**http://localhost:8119/products/1**

[

    {
        "seller": 2,
        "price": "75000",
        "description": "kemeja dengan garis putih",
        "id": 1,
        "title": "Kemeja",
        "stock": 50,
        "first_name": "Cindu"
    }
]
<br/>

### **POST**
- Menambahkan data baru ke table users 
<br/>

**http://localhost:8119/users**
{

    "id":"",
    "first_name":"Jauh",
    "last_name":"ari",
    "email":"jauhari@gmail.com",
    "phone_number":"081332051978",
    "type":"Buyer"
}

1 rows inserted!

<br/>

### **PUT**
- Mengubah data yang ada ditable users
 <br/>

 **http://localhost:8119/users/1**

{

    "id":"1",
    "first_name":"Pringga",
    "last_name":"Baskoro",
    "email":"pringga@gmail.com",
    "phone_number":"081338921972",
    "type":"Buyer"
}

1 rows updated!

<br/>

### **DELETE**
- Menghapus data dari entitas tertentu dimana saya mencoba untuk menghapus data yang terdapat pada tabel users dengan id 6
 <br/>
 http://localhost:8119/users/6

<br/>
1 rows deleted!