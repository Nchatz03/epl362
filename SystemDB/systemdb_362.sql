-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 11, 2018 at 03:23 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `v2`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `ID` int(4) NOT NULL,
  `Client_ID` int(4) NOT NULL,
  `Date` date NOT NULL,
  `Lawyer_ID` int(4) NOT NULL,
  `Branch_ID` int(4) NOT NULL,
  `Accomplish` tinyint(1) NOT NULL,
  `DateCreated` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`ID`, `Client_ID`, `Date`, `Lawyer_ID`, `Branch_ID`, `Accomplish`, `DateCreated`) VALUES
(1, 3, '2018-04-28', 1, 1, 1, ''),
(2, 2, '2018-04-17', 1, 1, 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `branches`
--

CREATE TABLE `branches` (
  `ID` int(11) NOT NULL,
  `Address` varchar(25) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `branches`
--

INSERT INTO `branches` (`ID`, `Address`) VALUES
(1, '12 Stasinou, lefkosia');

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `ID` int(4) NOT NULL,
  `Name` varchar(15) NOT NULL,
  `Surname` varchar(15) NOT NULL,
  `Sex` char(1) NOT NULL,
  `DOB` date NOT NULL,
  `NeedsUpdate` tinyint(1) NOT NULL,
  `DropIn` date NOT NULL,
  `Telephone` varchar(25) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Status` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`ID`, `Name`, `Surname`, `Sex`, `DOB`, `NeedsUpdate`, `DropIn`, `Telephone`, `Address`, `Status`) VALUES
(2, 'Nikolas', 'Chatzigiannis', 'M', '2018-04-18', 0, '0000-00-00', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `lawyers`
--

CREATE TABLE `lawyers` (
  `ID` int(11) NOT NULL,
  `Name` varchar(15) NOT NULL,
  `Surname` varchar(15) NOT NULL,
  `Branch_ID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lawyers`
--

INSERT INTO `lawyers` (`ID`, `Name`, `Surname`, `Branch_ID`) VALUES
(1, 'Loukas', 'Soleas', 1);

-- --------------------------------------------------------

--
-- Table structure for table `leaglopinions`
--

CREATE TABLE `leaglopinions` (
  `ID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `Description` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `recomendation`
--

CREATE TABLE `recomendation` (
  `ID` int(11) NOT NULL,
  `UserID` int(4) NOT NULL,
  `Description` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `Type` varchar(15) NOT NULL,
  `Username` varchar(15) DEFAULT NULL,
  `Password` varchar(25) DEFAULT NULL,
  `Branch_ID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `Type`, `Username`, `Password`, `Branch_ID`) VALUES
(5, 'LegalStaff', NULL, NULL, 1),
(6, 'Receptionist', 'gstavr02', '1234', 1);

-- --------------------------------------------------------

--
-- Table structure for table `usertypes`
--

CREATE TABLE `usertypes` (
  `Type` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usertypes`
--

INSERT INTO `usertypes` (`Type`) VALUES
('LegalStaff'),
('Receptionist');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `branches`
--
ALTER TABLE `branches`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `lawyers`
--
ALTER TABLE `lawyers`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `leaglopinions`
--
ALTER TABLE `leaglopinions`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `recomendation`
--
ALTER TABLE `recomendation`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `usertypes`
--
ALTER TABLE `usertypes`
  ADD PRIMARY KEY (`Type`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointments`
--
ALTER TABLE `appointments`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `branches`
--
ALTER TABLE `branches`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `lawyers`
--
ALTER TABLE `lawyers`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `leaglopinions`
--
ALTER TABLE `leaglopinions`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `recomendation`
--
ALTER TABLE `recomendation`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
