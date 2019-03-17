-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 13, 2019 at 06:14 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `simple_faculte_mandat`
--

--
-- Dumping data for table `entite_administratif`
--

INSERT INTO `entite_administratif` (`id`, `reference_entite_administratif`, `sous_projet`) VALUES
(1, 'FFF', 2);

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(9),
(9),
(9),
(9),
(9),
(9),
(9);

--
-- Dumping data for table `mandat`
--

INSERT INTO `mandat` (`id`, `date_debut_mandat`, `date_fin_mandat`, `entite_administratif`, `personnel`, `responsabilite`) VALUES
(1, '2010-10-10', '2019-03-13', 1, 6, 1);

--
-- Dumping data for table `personnel`
--

INSERT INTO `personnel` (`id`, `cin`, `code_echelle`, `code_echelon`, `date_acces_fonction_publique`, `date_activation`, `date_debut_type_personnel`, `date_exercice_echelle`, `date_naissance`, `etat_social`, `grade`, `lieu_affectation`, `lieu_naissance`, `nom`, `nombre_enfants`, `numero_location`, `prenom`, `type_personnel`) VALUES
(6, 'EE3', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0.00', NULL, NULL, 5);

--
-- Dumping data for table `projet`
--

INSERT INTO `projet` (`id`, `libellep`) VALUES
(1, 'AAA'),
(7, 'LL');

--
-- Dumping data for table `responsabilite`
--

INSERT INTO `responsabilite` (`id`, `poste`) VALUES
(1, 'XXX');

--
-- Dumping data for table `sous_projet`
--

INSERT INTO `sous_projet` (`id`, `reference_sous_projet`, `projet`) VALUES
(2, 'BBB', 1),
(3, 'CCC', 1),
(4, 'DDD', 1),
(8, 'SS', 7);

--
-- Dumping data for table `type_personnel`
--

INSERT INTO `type_personnel` (`id`, `libelle`) VALUES
(5, 'doyen');
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
