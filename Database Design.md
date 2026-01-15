🔐 User Management Service (ER – Logical)
User

id (PK)

email (unique)

role (SELLER, SUPPLIER, ADMIN)

status (PENDING, APPROVED, SUSPENDED, BLOCKED)

createdAt

updatedAt

📌 Purpose

Used across services for authorization

Referenced by other microservices

Contains no sensitive personal or password data

Credentials Entity (Authentication)

Stores authentication-related data only.

Credentials

id (PK)

userId (FK → User.id)

passwordHash

passwordSalt

lastPasswordChange

failedLoginAttempts

accountLocked (boolean)

📌 Key Security Rules

Passwords are never stored in plain text

Only hashed & salted passwords are persisted

Credentials are accessed only by authentication logic

Other microservices never see credentials

📌 Recommended Hashing

BCrypt or Argon2

UserProfile Entity (Personal Information)

Stores personal and residential information.

UserProfile

id (PK)

userId (FK → User.id)

firstName

lastName

dateOfBirth

age (derived or stored depending on requirements)

gender

nationalIdNumber

residentialAddressLine1

residentialAddressLine2

city

province / state

postalCode

country

createdAt

updatedAt

📌 Notes

age should ideally be derived from DOB, not manually updated

nationalIdNumber should be encrypted at rest

This data is not shared outside User Management Service

Role

id (PK)

name

AuditLog

id (PK)

adminId

action

targetUserId

timestamp

📦 Product & Inventory Service

Category

id (PK)

name

SubCategory

id (PK)

name

categoryId (FK)

Product

id (PK)

name

description

price

quantity

minBulkQuantity (nullable)

ownerId (Seller/Supplier ID)

ownerType (SELLER / SUPPLIER)

categoryId (FK)

subCategoryId (FK)

status

createdAt

ProductImage

id (PK)

productId (FK)

imageUrl (ImageKit)

🛒 Cart & Buying Service

Cart

id (PK)

userId

status (ACTIVE, CHECKED_OUT)

CartItem

id (PK)

cartId (FK)

productId

quantity

priceSnapshot

💰 Transaction & Order Service

Order

id (PK)

userId

status (CREATED, PAID, PROCESSING, COMPLETED, CANCELLED)

totalAmount

createdAt

OrderItem

id (PK)

orderId (FK)

productId

quantity

price

Transaction

id (PK)

orderId

paymentStatus

paymentReference

timestamp
