-- MySQL dump 10.13  Distrib 5.7.20, for Win64 (x86_64)
--
-- Host: localhost    Database: cosmetics
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `color` varchar(25) DEFAULT NULL,
  `picture` varchar(25) DEFAULT NULL,
  `discription` varchar(200) DEFAULT NULL,
  `ingredient` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'Peach Perfect Comfort Matte Foundation','TOO FACED','12 colors','img/img01.jpg','A 14-hour wear, comfortable matte foundation for a flawless-looking complexion. ','Water, Cyclopentasiloxane, Trimethylsiloxysilicate, Butylene Glycol, Trimethyl Pentaphenyl Trisiloxane, Silica, Phenyl Trimethicone, and more'),(2,'Vanish™ Seamless Finish Foundation Stick','HOURGLASS','26 colors','img/img02.jpg','A long-wearing foundation stick with the coverage of a concealer, fluidity of a liquid, and weightlessness of a powder for invisible, full coverage. ','Phenyl Trimethicone, C12-15 Alkyl Ethylhexanoate, Caprylic/Capric Triglyceride, Ethylhexyl Methoxycinnamate, Euphorbia Cerifera (Candelilla) Wax/Candelilla Cera, Ceresin, Polyethylene, Pentylene Glycol, Microcrystalline Wax/Cera Microcristallina, Polyglyceryl-2 Triisostearate,and more.'),(3,'Ultra HD Invisible Cover Foundation','MAKE UP FOR EVER','40 colors','img/img03.jpg','A bestselling HD foundation with an ultra-lightweight texture that melts into skin for unfiltered perfection in every light. ','Please check the MAKEUP FOREVER\'s website.'),(4,'Pro Filt\'r Soft Matte Longwear Foundation','FENTY BEAUTY BY RIHANNA','40 colors','img/img04.jpg','A soft matte, long-wear foundation with buildable, medium-to-full coverage, in a boundary-breaking range of shades. ','Water, Dimethicone, Talc, Peg-10 Dimethicone, Trimethylsiloxysilicate, Polypropylene, Isododecane, Cetyl Peg/Ppg-10/1 Dimethicone, Nylon-12, Hdi/Trimethylol Hexyllactone Crosspolymer, and more.'),(5,'#FauxFilter Foundation','HUDA BEAUTY','30 colors','img/img05.jpg','A full-coverage cream foundation that visibly conceals blemishes and imperfections, for a filter-like finish.','Water, Cyclopentasiloxane, Talc, Isododecane, PEG-10 Dimethicone, Polymethyl Methacrylate, Butylene Glycol, Glycerin, Polyglyceryl-4 Isostearate, Trimethylsiloxyphenyl Dimethicone, and more.'),(6,'Lock-It Foundation','KAT VON D','30 colors','img/img06.jpg','A high-pigment, full-coverage foundation with a matte finish and 24-hour wear—now with a new look in a total of 30 shades. ','Water, Dimethicone, Phenyl Trimethicone, Trimethylsiloxysilicate, Aluminum Starch Octenylsuccinate, Polysilicone-11, Butylene Glycol, Isononyl Isononanoate, Silica Dimethicone Silylate, and more.'),(7,'bareMinerals Original Foundation Broad Spectrum SPF 15','BAREMINERALS','30 colors','img/img07.jpg','A mineral foundation with buildable coverage and a natural-looking, radiant finish—available in 30 shades for all skintones. ','Mica, Titanium Dioxide, Iron Oxides, Bismuth Oxychloride.'),(8,'Naked Skin Weightless Ultra Definition Liquid Foundation','URBAN DECAY','26 colors','img/img08.jpg','An oil-free, lightweight liquid foundation that feels like wearing nothing at all, while leaving a demi-matte finish. ','Water, Cyclopentasiloxane, Butylene Glycol, Silica, Cyclohexasiloxane, Dimethicone, PEG/PPG-18/18 Dimethicone, Sodium Chloride, Phenoxyethanol, Caprylyl Glycol, Dimethicone/PEG-10/15 Crosspolymer, and more.'),(9,'Sheer Glow Foundation','NARS','20 colors','img/img09.jpg','A sheer, buildable coverage foundation with a radiant natural finish. ','Water, Cyclopentasiloxane, Butylene, Glycol, Glycerine, Polymethylsilsesquioxane, Dimethicone, Dimethicone/Vinal Dimethicone Crosspolymer, Triethylhexanoin, Peg-10 Dimethicone, and more.'),(10,'Re(marc)able Full Cover Foundation Concentrate','MARC JACOBS BEAUTY','22 colors','img/img10.jpg','An innovative foundation that delivers instant full coverage in a single dot—for less foundation for more coverage that lasts up to 24 hours.','Bis-hydroxytethoxypropyl Dimethicone, Ethyl Trisiloxane, Caprylyl Methicone, Isododecane, Polymethylsilsesquioxane, Trimethylsiloxysilicate, Dimethicone, Jojoba Esters, and more.'),(11,'All Hours Full Coverage Matte Foundation','YVES SAINT LAURENT','22 colors','img/img11.jpg','A new 24-Hour, full-coverage foundation that instantly blurs pores and fines lines and provides uninterrupted flawless wear that looks and feels just applied, all-day. ','Water, Cyclohexasiloxane, Alcohol Denat., Isododecane, Acrylates/Polytrimethylsiloxymethacrylate Copolymer, Butylene Glycol, Glycerin, Polymethylsilsesquioxane, and more.'),(12,'Flawless Fusion Ultra-Longwear Foundation','LAURA MERCIER','20 colors','img/img12.jpg','A 15-hour, long-wearing, oil-free, and transfer-resistant liquid foundation with a matte finish and weightless, medium-to-full coverage. ','Water, Isododecane, Methyltrimethicone, Cyclopentasiloxane, Butylene Glycol, Peg-9 Polydimethylsiloxyethyl Dimethicone, Silica, Dimethicone, Phenyl Trimethicone, Disteardimonium Hectorite, and more.'),(13,'Studio Skin 15 Hour Hydrating Foundation','SMASHBOX','22 colors','img/img13.jpg','An oil-free, hydrating foundation that gives you flawless skin for 15 hours—plus, it\'s tested to ensure that you look gorgeous in any light. ','Water, Cyclopentasiloxane, Trimethylsiloxysilicate, Butylene Glycol, Trimethyl Pentaphenyl Trisiloxane, Silica, Phenyl Trimethicone, Magnesium Sulfate, Polyglyceryl-3 Diisostearate, Tribehenin, and more.'),(14,'Beyond Perfecting Foundation + Concealer','CLINIQUE','27 colors','img/img14.jpg','A 24-hour wear, oil-free foundation and concealer in one that achieves a flawless look that lasts all day. ','Please check CLINIQUE\'s website.'),(15,'Ultimate Coverage Foundation','BECCA','20 colors','img/img15.jpg','A full-coverage yet breathable liquid foundation enriched with high concentrations of pigment and water—achieving coverage without the cake.','Dimethicone, Water, Phenyl Trimethicone, Trimethylsiloxysilicate, Peg/Ppg-18/18 Dimethicone, Aluminum Starch Octenylsuccinate, Polysilicone-11, Silica Dimethicone Silylate, and more.');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-08 16:25:36
