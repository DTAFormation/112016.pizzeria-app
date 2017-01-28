CREATE TABLE administrateur (
    id int PRIMARY KEY, 
    nom varchar(5000) NOT NULL,
  	prenom varchar(5000) NOT NULL,
    email  varchar(5000) NOT NULL,
  	mot_de_passe varchar(5000) NOT NULL
   );
   
   CREATE TABLE utilisateur (
	id int PRIMARY KEY, 
    nom varchar(5000) NOT NULL,
  	prenom varchar(5000) NOT NULL,
    email  varchar(5000) NOT NULL,
  	mot_de_passe varchar(5000) NOT NULL
    
   );
    CREATE TABLE livreur (
    id int PRIMARY KEY, 
    nom varchar(5000) NOT NULL,
  	prenom varchar(5000) NOT NULL,
    email  varchar(5000) NOT NULL,
  	mot_de_passe varchar(5000) NOT NULL
   );
   
   
   
   CREATE TABLE adresse (
       id int PRIMARY KEY,
       numero int, 
       adresse1 varchar(5000) NOT NULL, 
       adresse2 varchar(5000),
       adresse3 varchar(5000), 
       code_postal varchar(5) NOT NULL,
       ville varchar(5000)
   );
   
   
   CREATE TABLE client (
    id int PRIMARY KEY, 
    nom varchar(5000) NOT NULL,
  	prenom varchar(5000) NOT NULL,
    email  varchar(5000) NOT NULL,
  	mot_de_passe varchar(5000) NOT NULL,
    id_adresse int not null,
    foreign key (id_adresse) REFERENCES adresse(id)
   );


   
   CREATE TABLE pizza (
    id int PRIMARY KEY, 
    code_pizza varchar(15) NOT NULL,
    nom varchar(5000) NOT NULL,
    url  varchar(5000) NOT NULL,
    prix  decimal (5000) NOT NULL,
    note int  NOT NULL,
  	categorie varchar(5000) NOT NULL
   );

CREATE TABLE pizza (
    id int PRIMARY KEY, 
    code_pizza varchar(15) NOT NULL,
    nom varchar(5000) NOT NULL,
    url_pizza  varchar(5000) NOT NULL,
    prix  decimal (5000) NOT NULL,
    note int  NOT NULL,
  	categorie varchar(5000) NOT NULL
   );

CREATE TABLE pizza_commande(
    id int primary key,
    id_pizza int not null,
    foreign key (id_pizza) REFERENCES pizza(id),
    id_commande int not null --,
    foreign key (id_commande) REFERENCES commande(id)
);

CREATE TABLE menu_commande(
    id int primary key,
    id_pizza int not null,
    foreign key (id_pizza) REFERENCES pizza(id),
    id_commande int not null,
    foreign key (id_commande) REFERENCES commande(id)
);

CREATE TABLE promotion (
    id int PRIMARY KEY, 
    code_promotion varchar(5000) NOT NULL,
    nom varchar(5000) NOT NULL,
    description_promotion varchar(5000) NOT NULL,
    reduction  decimal, 
    type_reduction int,
   )

CREATE TABLE commande (
    id int PRIMARY KEY, 
    id_livreur int not null,
    id_client int not null,
    id_pizza_commande int not null,
    status_commande varchar(5000) not null, 
    code_promotion int not null, 
    prix decimal not null, 
    id_menu_commande int not null
   )

ALTER TABLE commande add constraint foreign key (id_livreur) REFERENCES livreur(id);
ALTER TABLE commande add constraint foreign key (id_client) REFERENCES client(id);
ALTER TABLE commande add constraint foreign key (id_pizza_commande) REFERENCES pizza_commande(id);
ALTER TABLE commande add constraint foreign key (code_promotion) REFERENCES promotion(id);
ALTER TABLE commande add constraint foreign key (id_menu_commande) REFERENCES menu_commande(id);

CREATE TABLE dessert(
    id int PRIMARY KEY, 
    nom varchar(5000) not null, 
    prix decimal not null,
    url_dessert varchar(5000)
    );
