-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Már 07. 08:37
-- Kiszolgáló verziója: 10.4.22-MariaDB
-- PHP verzió: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `tanar_bikerent`
--
CREATE DATABASE IF NOT EXISTS `tanar_bikerent` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `tanar_bikerent`;

DELIMITER $$
--
-- Eljárások
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `getBikes` ()  BEGIN
    	SELECT type, design, size, brake, speed, brand, code FROM bikes 
        INNER JOIN types ON bikes.type_id = types.id 
        INNER JOIN designs ON bikes.design_id = designs.id 
        INNER JOIN sizes ON bikes.size_id = sizes.id 
        INNER JOIN brakes ON bikes.brake_id = brakes.id 
        INNER JOIN brands ON bikes.brand_id = brands.id;
    END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getMembers` ()  BEGIN
    	SELECT name, email, phone, address, identity FROM renters;
    END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getRents` ()  BEGIN
        SELECT name, code, startdate, enddate, deposit FROM rents 
        INNER JOIN bikes ON rents.bike_id = bikes.id 
        INNER JOIN renters ON rents.renter_id = renters.id; 
    END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `bikes`
--

CREATE TABLE `bikes` (
  `id` int(11) NOT NULL,
  `code` char(5) DEFAULT NULL,
  `speed` int(11) DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL,
  `brake_id` int(11) DEFAULT NULL,
  `design_id` int(11) DEFAULT NULL,
  `size_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `bikes`
--

INSERT INTO `bikes` (`id`, `code`, `speed`, `brand_id`, `brake_id`, `design_id`, `size_id`, `type_id`) VALUES
(1, '12345', 6, 2, 3, 1, 1, 2),
(2, '12345', 12, 4, 1, 1, 3, 3),
(3, '12345', 18, 1, 2, 2, 3, 3),
(4, '12345', 21, 5, 3, 2, 2, 1),
(5, '12345', 1, 3, 4, 1, 4, 3);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `brakes`
--

CREATE TABLE `brakes` (
  `id` int(11) NOT NULL,
  `brake` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `brakes`
--

INSERT INTO `brakes` (`id`, `brake`) VALUES
(1, 'tárcsa'),
(2, 'v-fék'),
(3, 'patko'),
(4, 'kontra');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `brands`
--

CREATE TABLE `brands` (
  `id` int(11) NOT NULL,
  `brand` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `brands`
--

INSERT INTO `brands` (`id`, `brand`) VALUES
(1, 'KTM'),
(2, 'XFACT'),
(3, 'CSEPEL'),
(4, 'TREK'),
(5, 'SCOTT');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `designs`
--

CREATE TABLE `designs` (
  `id` int(11) NOT NULL,
  `design` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `designs`
--

INSERT INTO `designs` (`id`, `design`) VALUES
(1, 'női'),
(2, 'férfi');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `renters`
--

CREATE TABLE `renters` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `identity` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `renters`
--

INSERT INTO `renters` (`id`, `name`, `email`, `phone`, `address`, `identity`) VALUES
(1, 'Béla', 'bela@bela.hu', '123456789', 'Bélapátfalva Béla utca 1', '987654321'),
(2, 'Pista', 'pista@pista.hu', '123456789', 'Pistapátfalva Pista utca 1', '987654321'),
(3, 'Lajos', 'lajos@lajos.hu', '123456789', 'Lajospátfalva Lajos utca 1', '987654321'),
(4, 'Margit', 'margit@margit.hu', '123456789', 'Margitpátfalva Margit utca 1', '987654321'),
(5, 'János', 'jani@jani.hu', '123456789', 'Jánospátfalva János utca 1', '987654321');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `rents`
--

CREATE TABLE `rents` (
  `id` int(11) NOT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `deposit` int(11) DEFAULT NULL,
  `renter_id` int(11) DEFAULT NULL,
  `bike_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `rents`
--

INSERT INTO `rents` (`id`, `startdate`, `enddate`, `deposit`, `renter_id`, `bike_id`) VALUES
(1, '2021-01-15', '2021-01-20', 20000, 3, 3),
(2, '2021-01-30', '2021-02-20', 25000, 2, 4),
(3, '2021-02-10', '2021-02-25', 30000, 1, 2),
(4, '2021-04-08', '2021-04-22', 10000, 4, 1),
(5, '2021-05-11', '2021-05-31', 40000, 5, 5);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `sizes`
--

CREATE TABLE `sizes` (
  `id` int(11) NOT NULL,
  `size` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `sizes`
--

INSERT INTO `sizes` (`id`, `size`) VALUES
(1, '10'),
(2, '20'),
(3, '22'),
(4, '24'),
(5, '28');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `types`
--

CREATE TABLE `types` (
  `id` int(11) NOT NULL,
  `type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `types`
--

INSERT INTO `types` (`id`, `type`) VALUES
(1, 'országúti'),
(2, 'montenbájk'),
(3, 'városi'),
(4, 'bmx');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `bikes`
--
ALTER TABLE `bikes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `brand_id` (`brand_id`),
  ADD KEY `brake_id` (`brake_id`),
  ADD KEY `design_id` (`design_id`),
  ADD KEY `size_id` (`size_id`),
  ADD KEY `type_id` (`type_id`);

--
-- A tábla indexei `brakes`
--
ALTER TABLE `brakes`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `brands`
--
ALTER TABLE `brands`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `designs`
--
ALTER TABLE `designs`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `renters`
--
ALTER TABLE `renters`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `rents`
--
ALTER TABLE `rents`
  ADD PRIMARY KEY (`id`),
  ADD KEY `renter_id` (`renter_id`),
  ADD KEY `bike_id` (`bike_id`);

--
-- A tábla indexei `sizes`
--
ALTER TABLE `sizes`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `types`
--
ALTER TABLE `types`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `bikes`
--
ALTER TABLE `bikes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT a táblához `brakes`
--
ALTER TABLE `brakes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT a táblához `brands`
--
ALTER TABLE `brands`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT a táblához `designs`
--
ALTER TABLE `designs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT a táblához `renters`
--
ALTER TABLE `renters`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT a táblához `rents`
--
ALTER TABLE `rents`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT a táblához `sizes`
--
ALTER TABLE `sizes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT a táblához `types`
--
ALTER TABLE `types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `bikes`
--
ALTER TABLE `bikes`
  ADD CONSTRAINT `bikes_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `brands` (`id`),
  ADD CONSTRAINT `bikes_ibfk_2` FOREIGN KEY (`brake_id`) REFERENCES `brakes` (`id`),
  ADD CONSTRAINT `bikes_ibfk_3` FOREIGN KEY (`design_id`) REFERENCES `designs` (`id`),
  ADD CONSTRAINT `bikes_ibfk_4` FOREIGN KEY (`size_id`) REFERENCES `sizes` (`id`),
  ADD CONSTRAINT `bikes_ibfk_5` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`);

--
-- Megkötések a táblához `rents`
--
ALTER TABLE `rents`
  ADD CONSTRAINT `rents_ibfk_1` FOREIGN KEY (`renter_id`) REFERENCES `renters` (`id`),
  ADD CONSTRAINT `rents_ibfk_2` FOREIGN KEY (`bike_id`) REFERENCES `bikes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
