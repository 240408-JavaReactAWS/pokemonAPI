# pokemonAPI

This is the first project as a part of Revature training and is a Spring Boot Java API.

## Relationships 

This API models the following relationships:
- A Trainer has many pokemon
- A Pokemon belongs to a Trainer

### Pokemon
```
id,
nick-name,
level,
trainer_id
```

### Trainer
```
id,
name,
age,
region
```

### Endpoints
```
GET /trainers
POST /trainers
GET /trainers/{id}
PATCH /trainers/{id}
DELETE /trainers/{id}
GET /pokemon
POST /pokemon
GET /pokemon/{id}
PATCH /pokemon/{id}
DELETE /pokemon/{id}
```

# User Stories: Trainers

## Retrieve All Trainers

As a user, I should be able to submit a GET request on the endpoint GET localhost:{PORT}/trainers

- The response body contains a JSON representation of a list containing all trainers retrieved from the database
- The list is empty if there are no trainers
- Response status is 200 (OK)

## Create a New Trainer

As a user, I should be able to create a new Trainer on the endpoint POST localhost:{PORT}/trainers. The request body contains a JSON representation of a Trainer.

New Trainers will be successfully created if the provided name:
- Is not blank
- A Trainer with that name doesn't already exist

Successful new Trainer creations:
- The response body contains a JSON representation of the Trainer, including its id.
- The response status is the default 200 OK
- The new account is persisted to the database

Unsuccessful new Trainer creations:
- The response status is 400 (Client error)

## Retrieve a Trainer By the Trainer's id

As a user, I should be able to submit a GET request on the endpoint GET localhost:{PORT}/trainers/{id}.

- The response body contains a JSON representation of the Trainer identified by the id
- When a Trainer is found, the response status is 200 (OK)
- When a Trainer is not found, the response status is 404

## Update Trainer's Attributes By the Trainer's id

As a user, I should be able to submit a PATCH request on the endpoint PATCH localhost:{PORT}/trainers/{id}. The request body contains new values to replace on the Trainer with provided id.

A Trainer can be updated if:
- The trainer id already exists
- All attributes are not blank
- All non-numeric text provided to attributes as values are not over 255 characters

For successful updates:
- The response body contains the full updated Trainer (id, name,
age, region)
- The response status is 200 (OK)
- The Trainer found in the database reflects all updated values

For unsuccessful updates:
- The response status is 400 (Client error)

## Delete Trainer By id

As a user, I should be able to submit a DELETE request on the endpoint PATCH localhost:{PORT}/trainers/{id}. The request body contains the trainer's id.

A Trainer can be deleted if:
- The trainer id already exists

For successful updates:
- The response status is 200 (OK)
- The Trainer is removed from the database

For unsuccessful updates:
- The response status is 400 (Client error)

# User Stories: Pokemon

## Retrieve All Pokemon

As a user, I should be able to submit a GET request on the endpoint GET localhost:{PORT}/pokemon.

- The response body contains a JSON representation of a list containing all pokemon retrieved from the database
- The list is empty if there are no pokemon
- Response status is 200 (OK)

## Retrieve a Trainer By the Trainer's id

As a user, I should be able to submit a GET request on the endpoint GET localhost:{PORT}/pokemon/{id}.

- The response body contains a JSON representation of the Pokemon identified by the id
- When a Pokemon is found, the response status is 200 (OK)
- When a Pokemon is not found, the response status is 404