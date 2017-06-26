-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Lun 26 Juin 2017 à 15:02
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `qcm`
--
CREATE DATABASE IF NOT EXISTS `qcm` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `qcm`;

-- --------------------------------------------------------

--
-- Structure de la table `formateur`
--

DROP TABLE IF EXISTS `formateur`;
CREATE TABLE `formateur` (
  `idFormateur` int(11) NOT NULL,
  `Personne_idPersonne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `formateur`
--

INSERT INTO `formateur` (`idFormateur`, `Personne_idPersonne`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE `personne` (
  `idPersonne` int(11) NOT NULL,
  `identifiant` varchar(30) NOT NULL,
  `motdepasse` varchar(25) NOT NULL,
  `nom` varchar(80) NOT NULL,
  `prenom` varchar(80) NOT NULL,
  `dob` date NOT NULL,
  `emailPerso` varchar(100) NOT NULL,
  `emailENI` varchar(100) NOT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `adresse` varchar(500) DEFAULT NULL,
  `dateInscription` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`idPersonne`, `identifiant`, `motdepasse`, `nom`, `prenom`, `dob`, `emailPerso`, `emailENI`, `telephone`, `adresse`, `dateInscription`) VALUES
(1, '1', '1', 'battais', 'alexandre', '2017-06-26', 'alexandre.battais@eni.com', 'alexandre.battais@eni.com', NULL, NULL, '2017-06-26');

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `idQuestion` int(11) NOT NULL,
  `intitule` varchar(100) NOT NULL,
  `lienImage` varchar(255) DEFAULT NULL,
  `typeReponse` int(11) NOT NULL,
  `Theme_idTheme` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `reponse`
--

DROP TABLE IF EXISTS `reponse`;
CREATE TABLE `reponse` (
  `idReponse` int(11) NOT NULL,
  `libelleReponse` varchar(255) DEFAULT NULL,
  `lienImage` varchar(255) DEFAULT NULL,
  `position` int(11) DEFAULT NULL,
  `isValid` tinyint(1) NOT NULL,
  `Question_idQuestion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `reponse_stagiaire`
--

DROP TABLE IF EXISTS `reponse_stagiaire`;
CREATE TABLE `reponse_stagiaire` (
  `position` int(11) NOT NULL,
  `Test_idTest` int(11) NOT NULL,
  `Reponse_idReponse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `section`
--

DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `Test_test_id` int(11) NOT NULL,
  `Theme_idTheme` int(11) NOT NULL,
  `idSection` int(11) NOT NULL,
  `nbrQuestion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `stagiaire`
--

DROP TABLE IF EXISTS `stagiaire`;
CREATE TABLE `stagiaire` (
  `idStagiaire` int(11) NOT NULL,
  `Personne_idPersonne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `test`
--

DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `idTest` int(11) NOT NULL,
  `nbrQuestion` int(11) NOT NULL,
  `dateCreation` date NOT NULL,
  `libelleTest` varchar(255) NOT NULL,
  `tempsTest` time NOT NULL,
  `Stagiaire_idStagiaire` int(11) NOT NULL,
  `ReponseStagiaire_idStagiaire` int(11) NOT NULL,
  `test_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `theme`
--

DROP TABLE IF EXISTS `theme`;
CREATE TABLE `theme` (
  `idTheme` int(11) NOT NULL,
  `libelleTheme` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `nbrQuestion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `type_test`
--

DROP TABLE IF EXISTS `type_test`;
CREATE TABLE `type_test` (
  `id_type_test` int(11) NOT NULL,
  `libelleTypeTest` varchar(255) NOT NULL,
  `Test_test_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `formateur`
--
ALTER TABLE `formateur`
  ADD PRIMARY KEY (`idFormateur`),
  ADD KEY `Personne_idPersonne` (`Personne_idPersonne`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`idPersonne`),
  ADD UNIQUE KEY `idPersonne` (`idPersonne`,`identifiant`,`motdepasse`,`emailENI`);

--
-- Index pour la table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`idQuestion`);

--
-- Index pour la table `reponse`
--
ALTER TABLE `reponse`
  ADD PRIMARY KEY (`idReponse`),
  ADD KEY `Question_idQuestion` (`Question_idQuestion`);

--
-- Index pour la table `reponse_stagiaire`
--
ALTER TABLE `reponse_stagiaire`
  ADD PRIMARY KEY (`Test_idTest`,`Reponse_idReponse`),
  ADD KEY `Reponse_idReponse` (`Reponse_idReponse`);

--
-- Index pour la table `section`
--
ALTER TABLE `section`
  ADD PRIMARY KEY (`Test_test_id`,`Theme_idTheme`),
  ADD KEY `Theme_idTheme` (`Theme_idTheme`);

--
-- Index pour la table `stagiaire`
--
ALTER TABLE `stagiaire`
  ADD PRIMARY KEY (`idStagiaire`),
  ADD KEY `Personne_idPersonne` (`Personne_idPersonne`);

--
-- Index pour la table `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`idTest`),
  ADD UNIQUE KEY `test_id` (`test_id`);

--
-- Index pour la table `theme`
--
ALTER TABLE `theme`
  ADD PRIMARY KEY (`idTheme`);

--
-- Index pour la table `type_test`
--
ALTER TABLE `type_test`
  ADD PRIMARY KEY (`id_type_test`),
  ADD KEY `Test_test_id` (`Test_test_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `formateur`
--
ALTER TABLE `formateur`
  MODIFY `idFormateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `idPersonne` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `question`
--
ALTER TABLE `question`
  MODIFY `idQuestion` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `reponse`
--
ALTER TABLE `reponse`
  MODIFY `idReponse` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `stagiaire`
--
ALTER TABLE `stagiaire`
  MODIFY `idStagiaire` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `test`
--
ALTER TABLE `test`
  MODIFY `idTest` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `theme`
--
ALTER TABLE `theme`
  MODIFY `idTheme` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `type_test`
--
ALTER TABLE `type_test`
  MODIFY `id_type_test` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `formateur`
--
ALTER TABLE `formateur`
  ADD CONSTRAINT `formateur_ibfk_1` FOREIGN KEY (`Personne_idPersonne`) REFERENCES `personne` (`idPersonne`);

--
-- Contraintes pour la table `reponse`
--
ALTER TABLE `reponse`
  ADD CONSTRAINT `reponse_ibfk_1` FOREIGN KEY (`Question_idQuestion`) REFERENCES `question` (`idQuestion`);

--
-- Contraintes pour la table `reponse_stagiaire`
--
ALTER TABLE `reponse_stagiaire`
  ADD CONSTRAINT `reponse_stagiaire_ibfk_1` FOREIGN KEY (`Reponse_idReponse`) REFERENCES `reponse` (`idReponse`),
  ADD CONSTRAINT `reponse_stagiaire_ibfk_2` FOREIGN KEY (`Test_idTest`) REFERENCES `test` (`idTest`);

--
-- Contraintes pour la table `section`
--
ALTER TABLE `section`
  ADD CONSTRAINT `section_ibfk_1` FOREIGN KEY (`Test_test_id`) REFERENCES `test` (`idTest`),
  ADD CONSTRAINT `section_ibfk_2` FOREIGN KEY (`Theme_idTheme`) REFERENCES `theme` (`idTheme`);

--
-- Contraintes pour la table `stagiaire`
--
ALTER TABLE `stagiaire`
  ADD CONSTRAINT `stagiaire_ibfk_1` FOREIGN KEY (`Personne_idPersonne`) REFERENCES `personne` (`idPersonne`);

--
-- Contraintes pour la table `type_test`
--
ALTER TABLE `type_test`
  ADD CONSTRAINT `type_test_ibfk_1` FOREIGN KEY (`Test_test_id`) REFERENCES `test` (`idTest`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
