# 🛒 Kirana Inventory Management System

A backend-driven inventory management system designed for small shopkeepers to manage products, track stock, and analyze sales performance.

---

## 🚀 Features

* 🔐 JWT-based Authentication (Register/Login)
* 📦 Product Management (Add, View, Update, Delete)
* 📉 Low Stock Detection
* 🧊 Dead Stock Identification (unsold items)
* 💰 Revenue Calculation
* 📊 Top-Selling Product Analytics
* 🛍️ Sales & Purchase Tracking

---

## 🧠 Tech Stack

* **Language:** Java 21
* **Backend:** Spring Boot, Spring MVC
* **Security:** Spring Security, JWT Authentication
* **Persistence:** JPA/Hibernate
* **Database:** MySQL
* **API:** RESTful Web Services
* **Frontend (Demo):** HTML, CSS, JavaScript
* **Build Tool:** Maven
* **Version Control:** Git & GitHub

---

## 🏗️ Project Architecture

The application follows a layered architecture:

* **Controller Layer** → Handles HTTP requests
* **Service Layer** → Business logic implementation
* **Repository Layer** → Database interaction using JPA
* **Model Layer** → Entity classes

---

## 🔐 Authentication Flow

1. User registers with username & password
2. Password is encrypted using BCrypt
3. User logs in and receives a JWT token
4. Token is used to access secured APIs
5. All protected endpoints require `Authorization: Bearer <token>`

---

## 📊 Key Functionalities

### 📦 Product Management

* Add new products
* View all products
* Update stock and pricing

### 📉 Stock Monitoring

* Identify low stock items
* Detect dead stock (unsold for 15+ days)

### 💰 Sales & Analytics

* Record product sales
* Calculate total revenue
* Identify top-selling products

---

## 🌐 API Endpoints (Sample)

### 🔐 Authentication

* `POST /auth/register`
* `POST /auth/login`

### 📦 Products

* `GET /products`
* `POST /products`

### 📊 Analytics

* `GET /products/low-stock`
* `GET /products/dead-stock`
* `GET /sales/revenue`
* `GET /sales/top-selling`

---

## ⚙️ Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/<your-username>/kirana-inventory-system.git
```

### 2. Configure MySQL

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/kirana_db
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3. Run the application

```bash
mvn spring-boot:run
```

### 4. Access frontend

```text
http://localhost:8080/
```

---

## 🧪 Testing

Use Postman or the provided frontend to test APIs.

---

## ⚠️ Note

This project focuses primarily on backend architecture, API design, and business logic.
A minimal frontend is included for demonstration purposes.

---

## 🚧 Upcoming Features

* 🌍 Cloud Deployment (AWS / Render) for real-world accessibility
* 🔍 Advanced Search & Filtering (by category, price, and stock)

## 🚀 Future Improvements

* 🧠 Supplier Recommendation System
  Suggest the best suppliers based on pricing, availability, and purchase history.

* 👥 Multi-user Support
  Enable multiple shopkeepers with separate inventories.

* 📊 Advanced Analytics Dashboard
  Visual insights into revenue, product trends, and stock movement.

* 🔔 Smart Alerts
  Notifications for low stock and unusual sales patterns.

* 🛡️ Role-Based Access Control
  Admin and staff permissions.


---

## 👨‍💻 Author

**Preet Sahu**

---

## ⭐ If you found this useful

Give it a ⭐ on GitHub!
