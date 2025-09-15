# Task Managment

This Java Spring Boot project follows standard conventions for project structure and provides a REST API for managing tasks. The application is organized to be scalable and maintainable, making it easy for deployment and team collaboration

## Endpoints Summary
Most typical task manager REST endpoints in a Spring Boot project include:

GET /api/tasks
List all tasks, with optional pagination and filtering by status.

GET /api/tasks/{id}
Retrieve a specific task by its ID.

POST /api/tasks
Create a new task.

PUT /api/tasks/{id}
Update an existing task’s details.

DELETE /api/tasks/{id}
Delete a task by ID.

TaskManager/
├── .git/                     # Git version control metadata
├── .idea/                    # IntelliJ IDEA project settings
├── .mvn/                     # Maven wrapper support files
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── airtribe/
│   │   │           └── task_manager/
│   │   │               └── TaskManagerApplication.java  # Spring Boot main entry point
│   │   └── resources/
│   │       ├── application.properties                  # Spring Boot configuration
│   │       └── static/                                 # Static resources (if any)
│   │       └── templates/                              # HTML templates (if using Thymeleaf)
│   └── test/                                           # Unit & integration tests
├── target/                    # Build output directory (generated)
├── mvnw                       # Maven wrapper (Unix)
├── mvnw.cmd                   # Maven wrapper (Windows)
├── pom.xml                    # Maven project configuration
├── .gitignore
├── .gitattributes
└── HELP.md

# API Documenttation

[task manager.postman_collection.json](https://github.com/user-attachments/files/22326325/task.manager.postman_collection.json)
{
	"info": {
		"_postman_id": "977d8f9c-7217-4d4e-a68c-5b41a34bcb43",
		"name": "task manager",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "47860363",
		"_collection_link": "https://sukumar-k-s-team.postman.co/workspace/sukumar-k's-Workspace~8ef12f8f-f204-4918-88e9-4a6266bba3c3/collection/47860363-977d8f9c-7217-4d4e-a68c-5b41a34bcb43?action=share&source=collection_link&creator=47860363"
	},
	"item": [
		{
			"name": "Create Task",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "accept",
						"value": "*/*"
					},
					{
						"key": "Content-Type",
						"value": "application/json"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"title\": \"TO DO\",\n  \"description\": \"Complete the ToDo for today work.\",\n  \"priority\": \"HIGH\"\n}"
				},
				"url": {
					"raw": "http://localhost:8500/task",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8500",
					"path": [
						"task"
					]
				}
			},
			"response": []
		},
		{
			"name": "Get Task",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "accept",
						"value": "*/*"
					}
				],
				"url": {
					"raw": "http://localhost:8500/task/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8500",
					"path": [
						"task",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "Update Task status",
			"request": {
				"method": "PUT",
				"header": [
					{
						"key": "accept",
						"value": "*/*"
					}
				],
				"url": {
					"raw": "http://localhost:8500/task?taskId=1&taskStatus=IN_PROGRESS",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8500",
					"path": [
						"task"
					],
					"query": [
						{
							"key": "taskId",
							"value": "1"
						},
						{
							"key": "taskStatus",
							"value": "IN_PROGRESS"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Delete Task",
			"request": {
				"method": "DELETE",
				"header": [
					{
						"key": "accept",
						"value": "*/*"
					}
				],
				"url": {
					"raw": "http://localhost:8500/task/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8500",
					"path": [
						"task",
						"1"
					]
				}
			},
			"response": []
		}
	]
}
