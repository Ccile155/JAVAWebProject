-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 26 août 2019 à 07:27
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `mediatheque`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresses de livraison`
--

DROP TABLE IF EXISTS `adresses de livraison`;
CREATE TABLE IF NOT EXISTS `adresses de livraison` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomVille` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `adresses de livraison`
--

INSERT INTO `adresses de livraison` (`id`, `nomVille`) VALUES
(1, 'Crupies'),
(2, 'Paris');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `passwrd` varchar(20) NOT NULL,
  `adresse` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `emailUnique` (`email`) USING BTREE,
  KEY `adresse` (`adresse`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `email`, `passwrd`, `adresse`) VALUES
(1, 'Choupette', 'choupy@gmail.com', '0123', 1);

-- --------------------------------------------------------

--
-- Structure de la table `dvd`
--

DROP TABLE IF EXISTS `dvd`;
CREATE TABLE IF NOT EXISTS `dvd` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(100) NOT NULL,
  `auteur` varchar(50) NOT NULL,
  `duree` varchar(15) NOT NULL,
  `lecteur` varchar(50) DEFAULT NULL,
  `dateEmprunt` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `emprunteur` (`lecteur`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `dvd`
--

INSERT INTO `dvd` (`id`, `titre`, `auteur`, `duree`, `lecteur`, `dateEmprunt`) VALUES
(1, 'Kirikou et la Sorcière', 'Michel Ocelot', '1h14min', NULL, NULL),
(2, 'Welcome du Gattaca', 'Andrew Niccol', '2h1min', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `lecteurs`
--

DROP TABLE IF EXISTS `lecteurs`;
CREATE TABLE IF NOT EXISTS `lecteurs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `dateNaissance` date DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `passwrd` char(40) CHARACTER SET ascii NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `lecteurs`
--

INSERT INTO `lecteurs` (`id`, `nom`, `dateNaissance`, `email`, `passwrd`) VALUES
(1, 'Kikoo', '2019-05-15', 'kikoo@gmail.com', '123456'),
(2, 'Lolilol', '2000-01-31', 'lolilol@yahoo.fr', 'pirated'),
(5, 'Toto', '1968-03-02', 'toto@yahoo.fr', 'abc'),
(6, 'Benjamin', '1984-08-01', 'benjaminduf@gamil.com', '1081984'),
(7, 'Jacques', NULL, 'jaki@mail.fr', 'mdp0');

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

DROP TABLE IF EXISTS `livre`;
CREATE TABLE IF NOT EXISTS `livre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(100) NOT NULL,
  `auteur` varchar(50) NOT NULL,
  `nbpage` varchar(15) NOT NULL,
  `lecteur` varchar(50) DEFAULT NULL,
  `dateEmprunt` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `emprunteur` (`lecteur`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`id`, `titre`, `auteur`, `nbpage`, `lecteur`, `dateEmprunt`) VALUES
(1, '1984', 'George Orwell', '652p', NULL, NULL),
(2, 'Au guet !', 'Terry Pratchett', '620p', NULL, NULL),
(4, 'Les Furtifs', 'Alain Damasio', '257p', NULL, NULL);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `media`
-- (Voir ci-dessous la vue réelle)
--
DROP VIEW IF EXISTS `media`;
CREATE TABLE IF NOT EXISTS `media` (
`id` int(11)
,`titre` varchar(100)
,`auteur` varchar(50)
,`nbpage` varchar(15)
);

-- --------------------------------------------------------

--
-- Structure de la vue `media`
--
DROP TABLE IF EXISTS `media`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `media`  AS  select `livre`.`id` AS `id`,`livre`.`titre` AS `titre`,`livre`.`auteur` AS `auteur`,`livre`.`nbpage` AS `nbpage` from `livre` union select `dvd`.`id` AS `id`,`dvd`.`titre` AS `titre`,`dvd`.`auteur` AS `auteur`,`dvd`.`duree` AS `duree` from `dvd` ;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FK-client-ville` FOREIGN KEY (`adresse`) REFERENCES `adresses de livraison` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
