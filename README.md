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

SUCCESSFUL:
- The response body contains a JSON representation of a list containing all trainers retrieved from the database
- The list is empty if there are no trainers
- Response status is 200 (OK)

## Create a New Trainer

As a user, I should be able to create a new Trainer on the endpoint POST localhost:{PORT}/trainers. The request body contains a JSON representation of a Trainer.

SUCCESSFUL:
- The provided name is not blank
- The response body contains a JSON representation of the Trainer, including its id.
- The response status is the default 200 OK
- The new account is persisted to the database

UNSUCCESSFUL:
- The response status is 400 (Client error)

## Retrieve a Trainer By the Trainer's id

As a user, I should be able to submit a GET request on the endpoint GET localhost:{PORT}/trainers/{id}.

SUCCESSFUL:
- The response body contains a JSON representation of the Trainer identified by the id
- When a Trainer is found, the response status is 200 (OK)

UNSUCCESSFUL:
- When a Trainer is not found, the response status is 404

## Update Trainer's Attributes By the Trainer's id

As a user, I should be able to submit a PATCH request on the endpoint PATCH localhost:{PORT}/trainers/{id}. The request body contains new values to replace on the Trainer with provided id.

SUCCESSFUL:
- The trainer id already exists
- All attributes are not blank
- The response body contains the full updated Trainer (id, name,
age, region)
- The response status is 200 (OK)
- The Trainer found in the database reflects all updated values

UNSUCCESSFUL:
- The response status is 404 (Not Found)

## Delete Trainer By id

As a user, I should be able to submit a DELETE request on the endpoint DELETE localhost:{PORT}/trainers/{id}. The request body contains the trainer's id.

SUCCESSFUL:
- The trainer id already exists
- The response status is 200 (OK)
- The Trainer is removed from the database

UNSUCCESSFUL (or subsequent requests to the same id):
- The response status is 404 (Not Found)

# User Stories: Pokemon

## Retrieve All Pokemon

As a user, I should be able to submit a GET request on the endpoint GET localhost:{PORT}/pokemon.

- The response body contains a JSON representation of a list containing all pokemon retrieved from the database
- The list is empty if there are no pokemon
- Response status is 200 (OK)

## Retrieve a Pokemon By id

As a user, I should be able to submit a GET request on the endpoint GET localhost:{PORT}/pokemon/{id}.

- The response body contains a JSON representation of the Pokemon identified by the id
- When a Pokemon is found, the response status is 200 (OK)
- When a Pokemon is not found, the response status is 404

## Retrieve a Pokemon By Trainer id

As a user, I should be able to submit a GET request on the endpoint GET localhost:{PORT}trainers/{id}/pokemon.

- The response body contains a JSON representation of a list containing all pokemon from a specific trainer retrieved from the database
- When all Pokemon are found, the response status is 200 (OK)
- When a Trainer has no Pokemon, the response status is 200 (OK) and the body is empty
- When a Trainer is not found, the response status is 404

## Create a New Pokemon

As a user, I should be able to create a new Pokemon on the endpoint POST localhost:{PORT}/trainers/{id}/pokemon. The request body contains a JSON representation of a Pokemon.

SUCCESSFUL:
- The provided nickname is not blank
- The provided level is greater than zero.
- The provided pokedexEntry is greater than 0 and less than or equal to 1025 since that is the number of pokemon there are
- The response body contains a JSON representation of the Pokemon, including its id.
- The response status is the default 200 OK
- The new Pokemon is persisted to the database

UNSUCCESSFUL:
- When the response body contains faulty or incomplete information, the response status is 400 (Client error)
- When the Trainer is not found, the response status is 404

## Update Pokemon's Attributes By the Pokemon's id

As a user, I should be able to submit a PATCH request on the endpoint PATCH localhost:{PORT}/pokemon/{id}. The request body contains new values to replace on the Pokemon with provided id.

SUCCESSFUL:
- The pokemon id already exists
- Either include the updated nickname or level (or both) in the request body
- The response body contains the full updated Pokemon (id, nickname,
level, pokedexEntry, Trainer)
- The response status is 200 (OK)
- The Trainer found in the database reflects all updated values

UNSUCCESSFUL:
- The response status is 404 (NOT FOUND)

## Delete Pokemon By id

As a user, I should be able to submit a DELETE request on the endpoint DELETE localhost:{PORT}/pokemon/{id}. The request body contains the pokemon's id.

SUCCESSFUL:
- The pokemon id already exists
- The response status is 200 (OK)
- The Trainer is removed from the database

UNSUCCESSFUL (or subsequent requests to the same id):
- The response status is 404 (Not Found)

