-- phpMyAdmin SQL Dump
-- version 4.3.8
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 14, 2015 at 10:13 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `keppelcontest`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertUserComment`(IN pfullname VARCHAR(200), IN pusercomments LONGTEXT)
BEGIN
	INSERT INTO tblcomments(fullname, usercomments) VALUES (pfullname, pusercomments);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tblcomments`
--

CREATE TABLE IF NOT EXISTS `tblcomments` (
  `commentid` int(11) NOT NULL,
  `entrydate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fullname` varchar(200) NOT NULL,
  `usercomments` longtext NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblcomments`
--

INSERT INTO `tblcomments` (`commentid`, `entrydate`, `fullname`, `usercomments`) VALUES
(1, '2015-09-14 08:11:57', 'Reggie Senal', 'Test Test Test'),
(2, '2015-09-14 08:12:15', 'User No 2', 'Test Test Test');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblcomments`
--
ALTER TABLE `tblcomments`
  ADD PRIMARY KEY (`commentid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tblcomments`
--
ALTER TABLE `tblcomments`
  MODIFY `commentid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
