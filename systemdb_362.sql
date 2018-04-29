-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 28, 2018 at 09:32 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `systemdb_362`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `ID` int(4) NOT NULL,
  `Client_ID` int(4) NOT NULL,
  `Date` varchar(25) NOT NULL,
  `Lawyer_ID` int(4) NOT NULL,
  `Branch_ID` int(4) NOT NULL,
  `Accomplish` tinyint(1) DEFAULT NULL,
  `DateCreated` varchar(50) NOT NULL,
  `DropIn` tinyint(1) DEFAULT NULL,
  `CaseTrans` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`ID`, `Client_ID`, `Date`, `Lawyer_ID`, `Branch_ID`, `Accomplish`, `DateCreated`, `DropIn`, `CaseTrans`) VALUES
(14, 9, '2018-04-27', 1, 1, 1, '2018-04-28 03:45:00', 0, 'Case Type 1'),
(13, 12, '2018-04-26', 1, 1, 1, '2018-04-28 03:44:45', 0, 'Case Type 2'),
(11, 11, '2018-04-24', 1, 1, 1, '2018-04-28 03:44:12', 0, 'Case Type 2'),
(12, 10, '2018-04-25', 1, 1, 1, '2018-04-28 03:44:25', 0, 'Case Type 4'),
(10, 10, '2018-04-24', 1, 1, 1, '2018-04-28 03:43:44', 0, NULL),
(15, 9, '2018-04-28', 1, 1, 0, '2018-04-28 03:45:26', 0, NULL),
(16, 11, '2018-04-28', 1, 1, 1, '2018-04-28 03:46:25', 1, NULL),
(17, 11, '2018-04-19', 1, 1, 1, '2018-04-28 04:05:39', 0, NULL),
(26, 10, '2018-04-22', 1, 1, 0, '2018-04-28 09:33:08', 0, NULL),
(25, 10, '2018-04-22', 1, 1, NULL, '2018-04-28 09:33:01', 1, NULL);

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
-- Table structure for table `casetypes`
--

CREATE TABLE `casetypes` (
  `CaseType` varchar(30) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `casetypes`
--

INSERT INTO `casetypes` (`CaseType`) VALUES
('gvbgb'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test');

-- --------------------------------------------------------

--
-- Table structure for table `clientcase`
--

CREATE TABLE `clientcase` (
  `Client_ID` int(11) NOT NULL,
  `CaseTrans` varchar(100) NOT NULL,
  `Rec_LegOp` varchar(100) DEFAULT NULL,
  `Lawyer_ID` int(11) NOT NULL,
  `Illegal` tinyint(1) DEFAULT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `clientcase`
--

INSERT INTO `clientcase` (`Client_ID`, `CaseTrans`, `Rec_LegOp`, `Lawyer_ID`, `Illegal`, `ID`) VALUES
(9, 'Case Type 1', NULL, 1, 0, 6),
(10, 'Case Type 4', 'Legal Opinion 4', 1, 1, 7),
(11, 'Case Type 2', 'Legal Opinion 1', 1, 1, 8),
(12, 'Case Type 2', 'Recommendation 2', 1, 0, 9),
(-1, 'test', NULL, -1, NULL, 10),
(-1, 'test', NULL, -1, NULL, 11),
(-1, 'test', NULL, -1, NULL, 12),
(-1, 'test', NULL, -1, NULL, 13),
(-1, 'test', NULL, -1, NULL, 14),
(-1, 'test', NULL, -1, NULL, 15),
(-1, 'test', NULL, -1, NULL, 16),
(-1, 'test', NULL, -1, NULL, 17),
(-1, 'test', NULL, -1, NULL, 18),
(-1, 'test', NULL, -1, NULL, 19),
(-1, 'test', NULL, -1, NULL, 20);

-- --------------------------------------------------------

--
-- Table structure for table `clientremoved`
--

CREATE TABLE `clientremoved` (
  `Client_ID` int(11) NOT NULL,
  `Removed` tinyint(1) NOT NULL,
  `Remove_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clientremoved`
--

INSERT INTO `clientremoved` (`Client_ID`, `Removed`, `Remove_ID`) VALUES
(11, 1, 2),
(-1, 1, 3),
(-1, 1, 4),
(-1, 1, 5),
(-1, 1, 6),
(-1, 1, 7),
(-1, 1, 8),
(-1, 1, 9),
(-1, 1, 10),
(-1, 1, 11),
(-1, 1, 12),
(-1, 1, 13);

-- --------------------------------------------------------

--
-- Table structure for table `clientrequest`
--

CREATE TABLE `clientrequest` (
  `ClientID` int(11) NOT NULL,
  `Name` tinyint(1) NOT NULL,
  `Surname` tinyint(1) NOT NULL,
  `Address` tinyint(1) NOT NULL,
  `Phone` tinyint(1) NOT NULL,
  `DOB` tinyint(1) NOT NULL,
  `NameChange` varchar(25) DEFAULT NULL,
  `SurnameChange` varchar(25) DEFAULT NULL,
  `PhoneChange` varchar(25) DEFAULT NULL,
  `AddressChange` varchar(25) DEFAULT NULL,
  `DOBChange` varchar(25) DEFAULT NULL,
  `Accept` tinyint(1) DEFAULT NULL,
  `Request_ID` int(11) NOT NULL,
  `Done` tinyint(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `clientrequest`
--

INSERT INTO `clientrequest` (`ClientID`, `Name`, `Surname`, `Address`, `Phone`, `DOB`, `NameChange`, `SurnameChange`, `PhoneChange`, `AddressChange`, `DOBChange`, `Accept`, `Request_ID`, `Done`) VALUES
(9, 1, 0, 1, 0, 0, 'loukas', 'konnari', '9980990', 'nic', '1994-01-22', 0, 17, 1),
(9, 1, 0, 0, 0, 0, 'kwstis', 'konnari', '9980990', 'lemeso', '1994-01-22', 1, 18, 1),
(9, 1, 0, 1, 0, 0, 'loukas', 'konnari', '9980990', 'nic', '1994-01-22', 0, 16, 1),
(-1, 1, 1, 1, 1, 1, 'test', 'test', 'test', 'test', 'test', NULL, 19, 0),
(-1, 1, 1, 1, 1, 1, 'test', 'test', 'test', 'test', 'test', NULL, 20, 0),
(-1, 1, 1, 1, 1, 1, 'test', 'test', 'test', 'test', 'test', NULL, 21, 0),
(-1, 1, 1, 1, 1, 1, 'test', 'test', 'test', 'test', 'test', NULL, 22, 0),
(-1, 1, 1, 1, 1, 1, 'test', 'test', 'test', 'test', 'test', NULL, 23, 0),
(-1, 1, 1, 1, 1, 1, 'test', 'test', 'test', 'test', 'test', NULL, 24, 0),
(-1, 1, 1, 1, 1, 1, 'test', 'test', 'test', 'test', 'test', NULL, 25, 0),
(-1, 1, 1, 1, 1, 1, 'test', 'test', 'test', 'test', 'test', NULL, 26, 0),
(-1, 1, 1, 1, 1, 1, 'test', 'test', 'test', 'test', 'test', NULL, 27, 0),
(-1, 1, 1, 1, 1, 1, 'test', 'test', 'test', 'test', 'test', NULL, 28, 0),
(-1, 1, 1, 1, 1, 1, 'test', 'test', 'test', 'test', 'test', NULL, 29, 0);

-- --------------------------------------------------------

--
-- Table structure for table `clientrsecords`
--

CREATE TABLE `clientrsecords` (
  `Record_ID` int(11) NOT NULL,
  `ClientID` int(11) NOT NULL,
  `Name` varchar(25) CHARACTER SET utf8 NOT NULL,
  `Surname` varchar(25) CHARACTER SET utf8 NOT NULL,
  `DOB` varchar(25) CHARACTER SET utf8 NOT NULL,
  `Telephone` varchar(30) CHARACTER SET utf8 NOT NULL,
  `Address` varchar(25) CHARACTER SET utf8 NOT NULL,
  `Status` varchar(25) CHARACTER SET utf8 NOT NULL,
  `ChangedRecord` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clientrsecords`
--

INSERT INTO `clientrsecords` (`Record_ID`, `ClientID`, `Name`, `Surname`, `DOB`, `Telephone`, `Address`, `Status`, `ChangedRecord`) VALUES
(6, 9, 'kwstis', 'konnari', '1994-01-22', '9980990', 'lemeso', 'ACTIVE', 1),
(7, -1, 'test', 'test', 'test', 'test', 'test', 'ACTIVE', 1),
(8, -1, 'test', 'test', 'test', 'test', 'test', 'ACTIVE', 1),
(9, -1, 'test', 'test', 'test', 'test', 'test', 'ACTIVE', 1),
(10, -1, 'test', 'test', 'test', 'test', 'test', 'ACTIVE', 1),
(11, -1, 'test', 'test', 'test', 'test', 'test', 'ACTIVE', 1),
(12, -1, 'test', 'test', 'test', 'test', 'test', 'ACTIVE', 1),
(13, -1, 'test', 'test', 'test', 'test', 'test', 'ACTIVE', 1),
(14, -1, 'test', 'test', 'test', 'test', 'test', 'ACTIVE', 1),
(15, -1, 'test', 'test', 'test', 'test', 'test', 'ACTIVE', 1),
(16, -1, 'test', 'test', 'test', 'test', 'test', 'ACTIVE', 1),
(17, -1, 'test', 'test', 'test', 'test', 'test', 'ACTIVE', 1);

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `ID` int(4) NOT NULL,
  `Name` varchar(15) NOT NULL,
  `Surname` varchar(15) NOT NULL,
  `Sex` char(1) NOT NULL,
  `DOB` varchar(25) NOT NULL,
  `NeedsUpdate` tinyint(1) DEFAULT NULL,
  `Telephone` varchar(25) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Status` varchar(10) DEFAULT NULL,
  `Legal` tinyint(1) DEFAULT NULL,
  `ChangedRecord` tinyint(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`ID`, `Name`, `Surname`, `Sex`, `DOB`, `NeedsUpdate`, `Telephone`, `Address`, `Status`, `Legal`, `ChangedRecord`) VALUES
(12, 'Giorkos', 'Stauroy', 'M', '1994-1-10', NULL, '90909099', 'Aradipou', 'ACTIVE', 1, NULL),
(11, 'Loukas', 'Solea', 'M', '1994-10-13', 1, '9999998012', 'Ormideia', 'READ ONLY', 0, NULL),
(10, 'Nikollas', 'Xatzigiannis', 'M', '1994-08-10', NULL, '999999', 'lemeso', 'ACTIVE', 0, NULL),
(13, 'test', 'test', 'M', 'test', NULL, 'test', 'test', 'test', NULL, NULL),
(14, 'test', 'test', 'M', 'test', NULL, 'test', 'test', 'test', NULL, NULL),
(15, 'test', 'test', 'M', 'test', NULL, 'test', 'test', 'test', NULL, NULL),
(16, 'test', 'test', 'M', 'test', NULL, 'test', 'test', 'test', NULL, NULL),
(17, 'test', 'test', 'M', 'test', NULL, 'test', 'test', 'test', NULL, NULL),
(18, 'test', 'test', 'M', 'test', NULL, 'test', 'test', 'test', NULL, NULL),
(19, 'test', 'test', 'M', 'test', NULL, 'test', 'test', 'test', NULL, NULL),
(20, 'test', 'test', 'M', 'test', NULL, 'test', 'test', 'test', NULL, NULL),
(21, 'test', 'test', 'M', 'test', NULL, 'test', 'test', 'test', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `dispute`
--

CREATE TABLE `dispute` (
  `Client_ID` int(11) NOT NULL,
  `DisputeDate` varchar(20) NOT NULL,
  `Rec_LegOp` varchar(100) NOT NULL,
  `ID` int(11) NOT NULL,
  `CaseTrans` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dispute`
--

INSERT INTO `dispute` (`Client_ID`, `DisputeDate`, `Rec_LegOp`, `ID`, `CaseTrans`) VALUES
(-1, '2018-04-28 09:56:43', 'test', 20, '-1'),
(-1, '2018-04-28 09:54:19', 'test', 19, '-1'),
(12, '2018-04-28 04:17:35', 'Recommendation  3', 18, '9'),
(9, '2018-04-28 04:15:15', 'Legal Opinion 1', 17, '6'),
(-1, '2018-04-28 09:58:33', 'test', 21, '-1'),
(-1, '2018-04-28 09:58:47', 'test', 22, '-1'),
(-1, '2018-04-28 09:59:32', 'test', 23, '-1'),
(-1, '2018-04-28 10:03:21', 'test', 24, '-1'),
(-1, '2018-04-28 10:03:31', 'test', 25, '-1'),
(-1, '2018-04-28 10:04:54', 'test', 26, '-1'),
(-1, '2018-04-28 10:05:47', 'test', 27, '-1'),
(-1, '2018-04-28 10:05:55', 'test', 28, '-1'),
(-1, '2018-04-28 10:06:19', 'test', 29, '-1');

-- --------------------------------------------------------

--
-- Table structure for table `disputetransaction`
--

CREATE TABLE `disputetransaction` (
  `DisputeTrans_ID` int(11) NOT NULL,
  `Client_ID` int(11) NOT NULL,
  `DisputeDate` varchar(20) NOT NULL,
  `CaseTrans` varchar(100) NOT NULL,
  `Rec_LegOp` varchar(100) NOT NULL,
  `Lawyer_ID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `disputetransaction`
--

INSERT INTO `disputetransaction` (`DisputeTrans_ID`, `Client_ID`, `DisputeDate`, `CaseTrans`, `Rec_LegOp`, `Lawyer_ID`) VALUES
(11, -1, '2018-04-28 09:58:47', '-1', 'test', -1),
(10, -1, '2018-04-28 09:58:33', '-1', 'test', -1),
(9, -1, '2018-04-28 09:56:43', '-1', 'test', -1),
(8, -1, '2018-04-28 09:54:19', '-1', 'test', -1),
(7, 9, '2018-04-28 04:15:23', '6', 'Legal Opinion 1', 1),
(12, -1, '2018-04-28 09:59:32', '-1', 'test', -1),
(13, -1, '2018-04-28 10:03:21', '-1', 'test', -1),
(14, -1, '2018-04-28 10:03:31', '-1', 'test', -1),
(15, -1, '2018-04-28 10:04:54', '-1', 'test', -1),
(16, -1, '2018-04-28 10:05:47', '-1', 'test', -1),
(17, -1, '2018-04-28 10:05:55', '-1', 'test', -1),
(18, -1, '2018-04-28 10:06:19', '-1', 'test', -1);

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
-- Table structure for table `legalopinions`
--

CREATE TABLE `legalopinions` (
  `LegalStrategy` varchar(100) NOT NULL,
  `SideEffects` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `legalopinions`
--

INSERT INTO `legalopinions` (`LegalStrategy`, `SideEffects`) VALUES
('Legal Opinion 1', NULL),
('Legal Opinion 2', NULL),
('Legal Opinion 3', NULL),
('Legal Opinion 4', NULL),
('Legal Opinion 5', NULL),
('Ldsvf', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL),
('test', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `recommendations`
--

CREATE TABLE `recommendations` (
  `Recommendation` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `recommendations`
--

INSERT INTO `recommendations` (`Recommendation`) VALUES
('Recommendation  3'),
('Recommendation  1'),
('Recommendation  2'),
('Recommendation  4'),
('Recommendation  5'),
('gb'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test'),
('test');

-- --------------------------------------------------------

--
-- Table structure for table `unwilling`
--

CREATE TABLE `unwilling` (
  `Client_ID` int(11) NOT NULL,
  `Rec_LegOp` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `unwilling`
--

INSERT INTO `unwilling` (`Client_ID`, `Rec_LegOp`) VALUES
(9, 'Recommendation  1'),
(9, 'Legal Opinion 1'),
(10, 'Recommendation  2'),
(10, 'Recommendation  3'),
(11, 'Legal Opinion 2'),
(12, 'Recommendation  3'),
(12, 'Recommendation  1'),
(-1, 'test'),
(-1, 'test'),
(-1, 'test'),
(-1, 'test'),
(-1, 'test'),
(-1, 'test'),
(-1, 'test'),
(-1, 'test'),
(-1, 'test'),
(-1, 'test'),
(-1, 'test');

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

-- --------------------------------------------------------

--
-- Table structure for table `usertypes`
--

CREATE TABLE `usertypes` (
  `Type` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

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
-- Indexes for table `clientcase`
--
ALTER TABLE `clientcase`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `clientremoved`
--
ALTER TABLE `clientremoved`
  ADD PRIMARY KEY (`Remove_ID`);

--
-- Indexes for table `clientrequest`
--
ALTER TABLE `clientrequest`
  ADD PRIMARY KEY (`Request_ID`);

--
-- Indexes for table `clientrsecords`
--
ALTER TABLE `clientrsecords`
  ADD PRIMARY KEY (`Record_ID`);

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dispute`
--
ALTER TABLE `dispute`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `disputetransaction`
--
ALTER TABLE `disputetransaction`
  ADD PRIMARY KEY (`DisputeTrans_ID`,`Client_ID`);

--
-- Indexes for table `lawyers`
--
ALTER TABLE `lawyers`
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
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `branches`
--
ALTER TABLE `branches`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `clientcase`
--
ALTER TABLE `clientcase`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `clientremoved`
--
ALTER TABLE `clientremoved`
  MODIFY `Remove_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `clientrequest`
--
ALTER TABLE `clientrequest`
  MODIFY `Request_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `clientrsecords`
--
ALTER TABLE `clientrsecords`
  MODIFY `Record_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `dispute`
--
ALTER TABLE `dispute`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `disputetransaction`
--
ALTER TABLE `disputetransaction`
  MODIFY `DisputeTrans_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `lawyers`
--
ALTER TABLE `lawyers`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
