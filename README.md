📦 Inventory Management System

Microservices-Based E-Commerce & Inventory Platform

📖 Project Overview

This project is a scalable Inventory Management System built using a microservices architecture.
It supports multiple user roles involved in buying, selling, and managing products, with a focus on loose item sales, bulk supply, and administrative control.

The system is designed as a production-grade backend architecture, using:
Event-driven communication
Independent microservices
Secure role-based access
Cloud-ready deployment

🏗️ System Architecture

The platform follows a Microservices Architecture with the following characteristics:
Each microservice owns its own database
Communication via REST APIs and Kafka events
Services are independently deployable and scalable
Stateless backend services
Architecture Components

Frontend: Vue.js or Angular
API Gateway
Spring Boot Microservices
Kafka (Event Streaming)
MySQL (per service)
ImageKit (media storage)
Docker & Kubernetes (containerization and orchestration)

👥 User Roles & Permissions
1️⃣ Seller
Sells individual (loose) products.

Capabilities:

Create and manage product listings
Update prices and quantities
Upload product images
View sales history
Manage personal inventory

2️⃣ Supplier

Sells bulk products only, typically wholesale.

Capabilities:

Create bulk product listings
Set minimum order quantities
Manage bulk inventory
View supplier-level sales analytics

3️⃣ Admin

Manages system governance.

Capabilities:
Approve or reject user registrations
Suspend or permanently block users
View all users, products, and transactions
Monitor system-wide activity
Audit system logs

🔐 Authentication & Authorization

JWT-based authentication
Role-Based Access Control (RBAC)
Endpoint-level authorization using Spring Security
Admin-only protected endpoints
Token-based access for frontend clients

🗂️ Product Organization
Categories & Subcategories

Products are organized hierarchically.

Examples:

Electronics
Phones
Laptops

Homeware
Washing Machines
Dishwashers
Kettles

Furniture
Couches
Tables

Each product belongs to exactly:
One category
One subcategory
Product Management

Product Attributes:

Name
Description
Price
Available quantity
Category & subcategory
Seller or Supplier ownership
Product images (stored in ImageKit)
Status (active, out of stock, suspended)

🛒 Cart & Order Management
Cart Service
Add products to cart
Update quantities
Remove items
Calculate totals
Validate stock availability
Checkout Flow
Cart checkout creates an order
Inventory is validated and updated
Payment process initiated
Transaction recorded
Events published to Kafka
💰 Transactions & Orders
Transaction Management
A transaction represents a completed purchase.

Transaction Data:

Buyer details
Products purchased
Quantity per product
Purchase price
Total amount
Timestamp
Status (pending, completed, failed)
Order Tracking
Orders can be tracked by status

Order lifecycle:
Created
Paid
Processed
Completed
Cancelled

🧩 Microservices Overview
1️⃣ User Management Service

Handles user lifecycle and access control.

Responsibilities:

User registration
Authentication & authorization
Role assignment
User approval, suspension, blocking
Profile management
Tech: Spring Boot, Spring Security
Database: MySQL

2️⃣ Product & Inventory Service

Handles product listings and inventory.

Responsibilities:
Product CRUD operations
Category & subcategory management
Inventory updates
Image uploads via ImageKit
Stock availability checks
Tech: Spring Boot, ImageKit
Database: MySQL

3️⃣ Cart & Buying Service

Handles shopping behavior.

Responsibilities:

Cart creation and updates
Product browsing
Checkout requests
Communication with Transaction Service
Tech: Spring Boot
Database: MySQL

4️⃣ Transaction & Order Service
Handles financial and order data.

Responsibilities:

Transaction creation
Order status management
Purchase confirmations
Kafka event publishing
Tech: Spring Boot, Kafka
Database: MySQL

5️⃣ Notification Service

Handles system notifications.

Responsibilities:
Email notifications
Order confirmations
Account status alerts
Admin notifications

Tech: Spring Boot, Kafka
Database: Optional

6️⃣ Analytics & Reporting Service
Provides insights and metrics.

Responsibilities:
Sales analytics
Inventory reports
Supplier performance metrics
Admin dashboards

Tech: Spring Boot
Database: MySQL / Read replicas

📡 Event-Driven Architecture (Kafka)

Kafka enables asynchronous communication.

Example Events

UserApprovedEvent
UserSuspendedEvent
ProductCreatedEvent
InventoryUpdatedEvent
OrderPlacedEvent
TransactionCompletedEvent

Benefits
Loose coupling
Fault tolerance
Horizontal scalability
Improved performance

🌐 API Gateway
The API Gateway serves as the single entry point.

Responsibilities:

Request routing
Authentication validation
Rate limiting
Load balancing
API versioning
Tech: Spring Cloud Gateway

🔍 Search Service

Product search and filtering
Category-based search
Keyword-based queries
Tech: Elasticsearch (planned)

📊 Logging & Monitoring

Centralized logging
Audit logs for admin actions
Error tracking
System health monitoring

🛠️ Technology Stack
**Frontend**
Vue.js or Angular
Role-based UI rendering
REST API integration

**Backend**
Spring Boot (Microservices)
Spring Cloud Gateway
Spring Security
Kafka
Databases
MySQL (per microservice)

**Infrastructure**
Docker
Docker Compose
Kubernetes (future)
GitHub Actions (CI/CD)

🎯 Project Objectives

Demonstrate microservices best practices
Build an event-driven system
Implement real-world inventory flows
Showcase backend architecture skills

Build a portfolio-ready entrprise system
