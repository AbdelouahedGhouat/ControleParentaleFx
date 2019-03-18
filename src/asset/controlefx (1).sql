-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 18, 2019 at 03:57 PM
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
-- Database: `controlefx`
--

-- --------------------------------------------------------

--
-- Table structure for table `classe`
--

CREATE TABLE IF NOT EXISTS `classe` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) DEFAULT NULL,
  `ECOLEPRIVE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CLASSE_ECOLEPRIVE_ID` (`ECOLEPRIVE_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `classe`
--

INSERT INTO `classe` (`ID`, `NOM`, `ECOLEPRIVE_ID`) VALUES
(2, 'GG', 2),
(5, 'MMM', 2),
(6, 'JJ', 1),
(7, 'SS', 1);

-- --------------------------------------------------------

--
-- Table structure for table `devoir`
--

CREATE TABLE IF NOT EXISTS `devoir` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DATE` datetime DEFAULT NULL,
  `MATIERE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_DEVOIR_MATIERE_ID` (`MATIERE_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `devoir`
--

INSERT INTO `devoir` (`ID`, `DATE`, `MATIERE_ID`) VALUES
(1, '2019-03-12 00:00:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ecoleprive`
--

CREATE TABLE IF NOT EXISTS `ecoleprive` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `ecoleprive`
--

INSERT INTO `ecoleprive` (`ID`, `NOM`) VALUES
(1, 'MM'),
(2, 'CCC');

-- --------------------------------------------------------

--
-- Table structure for table `etudiant`
--

CREATE TABLE IF NOT EXISTS `etudiant` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  `CLASSE_ID` bigint(20) DEFAULT NULL,
  `PARENT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ETUDIANT_CLASSE_ID` (`CLASSE_ID`),
  KEY `FK_ETUDIANT_PARENT_ID` (`PARENT_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `etudiant`
--

INSERT INTO `etudiant` (`ID`, `NOM`, `PRENOM`, `CLASSE_ID`, `PARENT_ID`) VALUES
(1, 'Ghouat', 'amine', 2, 1),
(2, 'Ghouat', 'Anass', 5, 1),
(3, 'BBBB', 'DDD', 6, 2);

-- --------------------------------------------------------

--
-- Table structure for table `evenement`
--

CREATE TABLE IF NOT EXISTS `evenement` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DATE` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `CLASSE_ID` bigint(20) DEFAULT NULL,
  `TYPE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_EVENEMENT_CLASSE_ID` (`CLASSE_ID`),
  KEY `FK_EVENEMENT_TYPE_ID` (`TYPE_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `evenement`
--

INSERT INTO `evenement` (`ID`, `DATE`, `DESCRIPTION`, `NOM`, `CLASSE_ID`, `TYPE_ID`) VALUES
(1, '2019-03-12 00:00:00', 'volley', 'sport', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `matiere`
--

CREATE TABLE IF NOT EXISTS `matiere` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COEF` int(11) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `CLASSE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MATIERE_CLASSE_ID` (`CLASSE_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `matiere`
--

INSERT INTO `matiere` (`ID`, `COEF`, `NOM`, `CLASSE_ID`) VALUES
(1, 0, 'Math', 2),
(2, NULL, 'physique', 2);

-- --------------------------------------------------------

--
-- Table structure for table `notedevoir`
--

CREATE TABLE IF NOT EXISTS `notedevoir` (
  `ID` bigint(20) NOT NULL,
  `NOTE` double DEFAULT NULL,
  `DEVOIR_ID` bigint(20) DEFAULT NULL,
  `ETUDIENT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_NOTEDEVOIR_ETUDIENT_ID` (`ETUDIENT_ID`),
  KEY `FK_NOTEDEVOIR_DEVOIR_ID` (`DEVOIR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notedevoir`
--

INSERT INTO `notedevoir` (`ID`, `NOTE`, `DEVOIR_ID`, `ETUDIENT_ID`) VALUES
(1, 15, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `notifdevoir`
--

CREATE TABLE IF NOT EXISTS `notifdevoir` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DATELECTURE` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NOTEDEVOIR_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_NOTIFDEVOIR_NOTEDEVOIR_ID` (`NOTEDEVOIR_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `notifdevoir`
--

INSERT INTO `notifdevoir` (`ID`, `DATELECTURE`, `DESCRIPTION`, `NOTEDEVOIR_ID`) VALUES
(1, '2019-03-13 00:00:00', 'Merci', 1);

-- --------------------------------------------------------

--
-- Table structure for table `notifevent`
--

CREATE TABLE IF NOT EXISTS `notifevent` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DATELECTURE` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `ETUDIANT_ID` bigint(20) DEFAULT NULL,
  `EVENEMENT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_NOTIFEVENT_EVENEMENT_ID` (`EVENEMENT_ID`),
  KEY `FK_NOTIFEVENT_ETUDIANT_ID` (`ETUDIANT_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `notifevent`
--

INSERT INTO `notifevent` (`ID`, `DATELECTURE`, `DESCRIPTION`, `ETUDIANT_ID`, `EVENEMENT_ID`) VALUES
(1, '2019-03-29 00:00:00', '', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `parent`
--

CREATE TABLE IF NOT EXISTS `parent` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CIN` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  `TEL` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `parent`
--

INSERT INTO `parent` (`ID`, `CIN`, `NOM`, `PASSWORD`, `PRENOM`, `TEL`) VALUES
(1, '123', 'Ghouat', '123', 'abdou', 69999),
(2, 'EE', 'SASA', '123', 'LALA', 45454);

-- --------------------------------------------------------

--
-- Table structure for table `sequence`
--

CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '0');

-- --------------------------------------------------------

--
-- Table structure for table `typeevent`
--

CREATE TABLE IF NOT EXISTS `typeevent` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `typeevent`
--

INSERT INTO `typeevent` (`ID`, `TYPE`) VALUES
(1, 'LLLL');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `FK_CLASSE_ECOLEPRIVE_ID` FOREIGN KEY (`ECOLEPRIVE_ID`) REFERENCES `ecoleprive` (`ID`);

--
-- Constraints for table `devoir`
--
ALTER TABLE `devoir`
  ADD CONSTRAINT `FK_DEVOIR_MATIERE_ID` FOREIGN KEY (`MATIERE_ID`) REFERENCES `matiere` (`ID`);

--
-- Constraints for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `FK_ETUDIANT_CLASSE_ID` FOREIGN KEY (`CLASSE_ID`) REFERENCES `classe` (`ID`),
  ADD CONSTRAINT `FK_ETUDIANT_PARENT_ID` FOREIGN KEY (`PARENT_ID`) REFERENCES `parent` (`ID`);

--
-- Constraints for table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `FK_EVENEMENT_CLASSE_ID` FOREIGN KEY (`CLASSE_ID`) REFERENCES `classe` (`ID`),
  ADD CONSTRAINT `FK_EVENEMENT_TYPE_ID` FOREIGN KEY (`TYPE_ID`) REFERENCES `typeevent` (`ID`);

--
-- Constraints for table `matiere`
--
ALTER TABLE `matiere`
  ADD CONSTRAINT `FK_MATIERE_CLASSE_ID` FOREIGN KEY (`CLASSE_ID`) REFERENCES `classe` (`ID`);

--
-- Constraints for table `notedevoir`
--
ALTER TABLE `notedevoir`
  ADD CONSTRAINT `FK_NOTEDEVOIR_DEVOIR_ID` FOREIGN KEY (`DEVOIR_ID`) REFERENCES `devoir` (`ID`),
  ADD CONSTRAINT `FK_NOTEDEVOIR_ETUDIENT_ID` FOREIGN KEY (`ETUDIENT_ID`) REFERENCES `etudiant` (`ID`);

--
-- Constraints for table `notifdevoir`
--
ALTER TABLE `notifdevoir`
  ADD CONSTRAINT `FK_NOTIFDEVOIR_NOTEDEVOIR_ID` FOREIGN KEY (`NOTEDEVOIR_ID`) REFERENCES `notedevoir` (`ID`);

--
-- Constraints for table `notifevent`
--
ALTER TABLE `notifevent`
  ADD CONSTRAINT `FK_NOTIFEVENT_ETUDIANT_ID` FOREIGN KEY (`ETUDIANT_ID`) REFERENCES `etudiant` (`ID`),
  ADD CONSTRAINT `FK_NOTIFEVENT_EVENEMENT_ID` FOREIGN KEY (`EVENEMENT_ID`) REFERENCES `evenement` (`ID`);
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
