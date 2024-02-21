# **Hibernate**

## **`get()` v/s `load()`**

- `get()` and `load()` methods in Hibernate are used to retrieve entities based on their primary keys. The main difference lies in their retrieval strategy and behavior regarding database interaction. 
- `get()` fetches the entity immediately and returns a fully initialized object.
- `load()` returns a proxy object and initializes it lazily when required. 