# pokemonAPI
Project 1


Table Pokemon
id
level
trainer_id
type_id
nick-name
 
Table Trainer
id
name
age
region
 
Table Type
id
description
element
name

Relationships:
 
-Trainer has many pokemon
-Pokemon belongs to a trainer
-Pokemon belongs to a type
-Type has many pokemon

Endpoints
/pokemon
/pokemon/{id}
/trainers
/trainers/{id}
/trainers/{id}/pokemon
/trainers/{id}/pokemon/{id}