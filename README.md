# ElevateX – Intelligent Multi-Lift Scheduling System

[![Java](https://img.shields.io/badge/Java-21-orange)](https://www.oracle.com/java/) [![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.1-brightgreen)](https://spring.io/projects/spring-boot) [![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)](https://www.mysql.com/)

---

## Overview
ElevateX is a **smart elevator scheduling system** for a **13‑floor building with 2 lifts**.  
It assigns the **nearest available elevator** to requests and queues pending ones when both are busy.  
Built with **Java, Spring Boot, and MySQL**, it demonstrates **real-time scheduling, REST APIs, and persistence** — perfect for interviews or portfolio highlights.

---

## Features
- Nearest‑lift assignment
- Pending request queue
- REST APIs for requests, history, and system status
- MySQL persistence with JPA/Hibernate
- Dashboard view for lift positions

---

## Tech Stack
| Layer       | Technology               |
| ----------- | ------------------------ |
| Backend     | Java 21, Spring Boot 4.0 |
| Database    | MySQL 8.0                |
| ORM         | JPA / Hibernate          |
| Testing     | Postman                  |
| Build Tool  | Maven                    |

---

## API Endpoints
| Method | Endpoint                | Description                  |
| ------ | ----------------------- | ---------------------------- |
| GET    | `/api/elevators`        | All elevators with status    |
| POST   | `/api/requests`         | Create a lift request        |
| GET    | `/api/requests`         | Request history              |
| GET    | `/api/elevators/status` | Dashboard view of positions  |

---

## Demo Flow
1. **Check lifts** → GET `/api/elevators`
2. **Request Ground → Top** → Lift‑A assigned
3. **Request Floor5 → 2** → Lift‑B assigned
4. **Request Floor10 → 1** → Queued (pending)
5. **View history** → GET `/api/requests`
6. **Dashboard** → GET `/api/elevators/status`

---

## Setup
```bash
git clone <your-repo-url>
cd ElevateX
```
1. Configure MySQL (`elevatex_db`) in `application.properties`
2. Run `data.sql` or let Hibernate auto‑create tables
3. Start app:
   ```bash
   mvn spring-boot:run
   ```  
4. Test APIs via Postman

---

## Structure
```
src/
 ├─ main/java/com/elevatex/elevatex/
 │    ├─ controller/   # REST controllers
 │    ├─ model/        # Entities & enums
 │    ├─ repository/   # JPA repositories
 │    ├─ service/      # Scheduling logic
 │    └─ ElevateXApplication.java
 └─ resources/
      ├─ application.properties
      └─ data.sql
```

---

## Resume Highlight
> Developed an intelligent elevator scheduling system for a 13‑floor building with real‑time assignment, pending request handling, REST APIs, and MySQL persistence.

