
## 1️⃣ API design table

| Function                 | Method | Endpoint                  | Request Body          | Response Code           |
|--------------------------|--------|---------------------------|-----------------------|-------------------------|
| Get all books            | GET    | `/api/books`              | ❌                     | 200 OK                  |
| Get a book by ID         | GET    | `/api/books/{id}`         | ❌                     | 200 OK / 404 Not Found  |
| Create a new book        | POST   | `/api/books`              | JSON book object      | 201 Created             |
| Update an entire book    | PUT    | `/api/books/{id}`         | JSON full book object | 200 OK / 204 No Content |
| Update a field of book   | PATCH  | `/api/books/{id}`         | JSON partial fields   | 200 OK                  |
| Delete a book            | DELETE | `/api/books/{id}`         | ❌                     | 204 No Content          |
| Find books by the author | GET    | `/api/books?author=HaZoe` | ❌                     | 200 OK                  |

---

## 2️⃣ Request Body example

### POST / PUT

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "publishedYear": 2008,
  "isbn": "9780132350884"
}
```

### PATCH

```json
{
  "publishedYear": 2024
}
```

---

# 📌 Investigate

---

## 🔥 1. Distinguish PUT vs PATCH?

| PUT                            | PATCH                                 |
|--------------------------------|---------------------------------------|
| Update the entire resource     | Update a part of resource             |
| Send full object               | Send only fields which need to update |
| Express **idempotent**         | Can idempotent or no                  |
| If missing field → can be null | No effect to the other fields         |

### Example

PUT:

```json
{ "title": "New Title" }
```

→ If API requires full object, the other fields can be null.

PATCH:

```json
{ "title": "New Title" }
```

→ Only update title.

---

## 🔥 2. when create a new book, which should API return 200 hay 201? Why?

✅ **REST standard is 201 Created**

Because:

* 201 means resource created successfully
* Can add more headers:

```
Location: /api/books/123
```
To help client know where the new resource is

200 OK is still correct, but it is not semantic by 201.

---

## 🔥 3. what are differences between 401 vs 403?

| 401 Unauthorized                 | 403 Forbidden                                 |
|----------------------------------|-----------------------------------------------|
| Not logged in yet or wrong token | Logged in but there is not enough permissions |
| Authentication Error             | Authorization Error                           |

Example:

* No send JWT → 401
* Being normal user but calling API admin → 403

---

## 🔥 4. API returns 500 — where should we debug?

500 = server side error.

Debug standard process:

### Step 1: Check log server

* Stacktrace
* NullPointerException?
* DB connection fail?
* Timeout?

### Step 2: Check request input

* Is JSON correct format?
* Missing field?
* Validate fail?

### Step 3: Check database

* Query error?
* Constraint violation?
* Transaction rollback?

### Step 4: Check external service (If had)

* Call the other service met timeout?
* Circuit breaker?

### Step 5: Reproduce by Postman / curl

