-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 13, 2017 at 11:41 PM
-- Server version: 5.7.20-0ubuntu0.16.04.1
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `TAA_PROJECT`
--

-- --------------------------------------------------------

--
-- Table structure for table `activity`
--

CREATE TABLE `activity` (
  `identifier` bigint(20) NOT NULL,
  `description` longtext,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `activity`
--

INSERT INTO `activity` (`identifier`, `description`, `image`, `name`) VALUES
(1, 'Si tout comme brice tu adores la glisse même si tu n\'habite pas à Nice alors cette activité est faite pour toi', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQc0WZMiPt0nN-lJWnPiTe84jhGi0hWdgKA0UOgb0hZt0KCSy59', 'SURF'),
(2, 'Le GR20 ça vous connait, la montagne ne vous effraie alors essayer la randonnée. Il fait un temps pour aller vadrouiller dehors', 'http://cms.cotedazur-tourisme.com/userfiles/image/montagne-ete/activites/randonnee-pedestre.jpg', 'Randonnée'),
(3, 'llud tamen te esse admonitum volo, primum ut qualis es talem te esse omnes existiment ut, quantum a rerum turpitudine abes, tantum te a verborum libertate seiungas; deinde ut ea in alterum ne dicas, quae cum tibi falso responsa sint, erubescas. Quis est enim, cui via ista non pateat, qui isti aetati atque etiam isti dignitati non possit quam velit petulanter, etiamsi sine ulla suspicione, at non sine argumento male dicere? Sed istarum partium culpa est eorum, qui te agere voluerunt; laus pudoris tui, quod ea te invitum dicere videbamus, ingenii, quod ornate politeque dixisti', 'https://www.parispass.fr/images/attractions/louvre.jpg', 'musé'),
(4, 'llud tamen te esse admonitum volo, primum ut qualis es talem te esse omnes existiment ut, quantum a rerum turpitudine abes, tantum te a verborum libertate seiungas; deinde ut ea in alterum ne dicas, quae cum tibi falso responsa sint, erubescas. Quis est enim, cui via ista non pateat, qui isti aetati atque etiam isti dignitati non possit quam velit petulanter, etiamsi sine ulla suspicione, at non sine argumento male dicere? Sed istarum partium culpa est eorum, qui te agere voluerunt; laus pudoris tui, quod ea te invitum dicere videbamus, ingenii, quod ornate politeque dixisti', 'http://www.sautparachute.com/wp-content/uploads/2014/01/ou-faire-un-saut-parachute-en-france.jpg', 'saut en parachute'),
(5, 'Illud tamen te esse admonitum volo, primum ut qualis es talem te esse omnes existiment ut, quantum a rerum turpitudine abes, tantum te a verborum libertate seiungas; deinde ut ea in alterum ne dicas, quae cum tibi falso responsa sint, erubescas. Quis est enim, cui via ista non pateat, qui isti aetati atque etiam isti dignitati non possit quam velit petulanter, etiamsi sine ulla suspicione, at non sine argumento male dicere? Sed istarum partium culpa est eorum, qui te agere voluerunt; laus pudoris tui, quod ea te invitum dicere videbamus, ingenii, quod ornate politeque dixisti', 'http://www.club.fft.fr/tc.ria/52560328_d/data_1/jpg/te/tennis1200x200.jpg', 'tennis'),
(6, 'Illud tamen te esse admonitum volo, primum ut qualis es talem te esse omnes existiment ut, quantum a rerum turpitudine abes, tantum te a verborum libertate seiungas; deinde ut ea in alterum ne dicas, quae cum tibi falso responsa sint, erubescas. Quis est enim, cui via ista non pateat, qui isti aetati atque etiam isti dignitati non possit quam velit petulanter, etiamsi sine ulla suspicione, at non sine argumento male dicere? Sed istarum partium culpa est eorum, qui te agere voluerunt; laus pudoris tui, quod ea te invitum dicere videbamus, ingenii, quod ornate politeque dixisti.', 'http://santecool.net/wp-content/uploads/2014/01/SKI.jpg', 'ski'),
(7, 'Illud tamen te esse admonitum volo, primum ut qualis es talem te esse omnes existiment ut, quantum a rerum turpitudine abes, tantum te a verborum libertate seiungas; deinde ut ea in alterum ne dicas, quae cum tibi falso responsa sint, erubescas. Quis est enim, cui via ista non pateat, qui isti aetati atque etiam isti dignitati non possit quam velit petulanter, etiamsi sine ulla suspicione, at non sine argumento male dicere? Sed istarum partium culpa est eorum, qui te agere voluerunt; laus pudoris tui, quod ea te invitum dicere videbamus, ingenii, quod ornate politeque dixisti.', 'https://www.pechetarn.fr/components/images/tarifs-cartes-peche-tarn.jpg', 'pêche'),
(8, 'Illud tamen te esse admonitum volo, primum ut qualis es talem te esse omnes existiment ut, quantum a rerum turpitudine abes, tantum te a verborum libertate seiungas; deinde ut ea in alterum ne dicas, quae cum tibi falso responsa sint, erubescas. Quis est enim, cui via ista non pateat, qui isti aetati atque etiam isti dignitati non possit quam velit petulanter, etiamsi sine ulla suspicione, at non sine argumento male dicere? Sed istarum partium culpa est eorum, qui te agere voluerunt; laus pudoris tui, quod ea te invitum dicere videbamus, ingenii, quod ornate politeque dixisti', 'http://guides-belleville.com/wp-content/uploads/2014/04/escalade.jpg', 'escalade'),
(9, 'Illud tamen te esse admonitum volo, primum ut qualis es talem te esse omnes existiment ut, quantum a rerum turpitudine abes, tantum te a verborum libertate seiungas; deinde ut ea in alterum ne dicas, quae cum tibi falso responsa sint, erubescas. Quis est enim, cui via ista non pateat, qui isti aetati atque etiam isti dignitati non possit quam velit petulanter, etiamsi sine ulla suspicione, at non sine argumento male dicere? Sed istarum partium culpa est eorum, qui te agere voluerunt; laus pudoris tui, quod ea te invitum dicere videbamus, ingenii, quod ornate politeque dixisti.', 'http://www.ot-portovecchio.com/admin/files/1227/1-Club-Voile-Bonifacio.jpg', 'voile');

-- --------------------------------------------------------

--
-- Table structure for table `adequate_activities_weather`
--

CREATE TABLE `adequate_activities_weather` (
  `identifier` bigint(20) NOT NULL,
  `max_humidity` double DEFAULT NULL,
  `max_pluviometry` double DEFAULT NULL,
  `max_sunshine` double DEFAULT NULL,
  `max_temperature` double DEFAULT NULL,
  `max_wind_condition` double DEFAULT NULL,
  `min_humidity` double DEFAULT NULL,
  `min_pluviometry` double DEFAULT NULL,
  `min_sunshine` double DEFAULT NULL,
  `min_temperature` double DEFAULT NULL,
  `min_wind_condtion` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `adequate_weather` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `favourite_activities`
--

CREATE TABLE `favourite_activities` (
  `identifier` bigint(20) NOT NULL,
  `activity_fk` bigint(20) NOT NULL,
  `user_fk` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `favourite_activities`
--

INSERT INTO `favourite_activities` (`identifier`, `activity_fk`, `user_fk`) VALUES
(1, 1, 3),
(2, 1, 1),
(3, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `favourite_location`
--

CREATE TABLE `favourite_location` (
  `identifier` bigint(20) NOT NULL,
  `location_fk` bigint(20) DEFAULT NULL,
  `user_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `invalid_tokens`
--

CREATE TABLE `invalid_tokens` (
  `identifier` bigint(20) NOT NULL,
  `value` varchar(600) NOT NULL,
  `user_username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `invalid_tokens`
--

INSERT INTO `invalid_tokens` (`identifier`, `value`, `user_username`) VALUES
(12, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ6aWdoJHtzZWN1cml0eS5qd3QudXNlcm5hbWUuc3VmZml4IiwiYXVkIjoid2ViIiwiZXhwIjoxNTA5NjM5NjY5LCJpYXQiOjE1MDk1Mzg4Njl9.xwwozLNx-J3XCt9zcw_uXn5sN5_qnozGcF6owjyS0-DazTvxIzDvOgVTywMFQJb1ODyWi8rWSpZArkjJrrKDHA', NULL),
(13, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ6aWdoOiQwIiwiYXVkIjoid2ViIiwiZXhwIjoxNTA5NjQwNTE4LCJpYXQiOjE1MDk1Mzk3MTh9.F64tVBSQ2n4mY_X40TCIwPU4vIWAC2E0JFVSRUHgFfc9C6EAyhlphNLS6qxhuwfnhqbABxdjdZeWEw3BN_tFCQ', 'zigh'),
(14, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ6aWdoOjIwMTctMTEtMDEgMTM6NDg6MTI_JDEiLCJhdWQiOiJ3ZWIiLCJleHAiOjE1MDk2NDEyOTIsImlhdCI6MTUwOTU0MDQ5Mn0.ihUx426Upp9RwVTjOwoHQYS0x0KyCQVhXBtVBzbqgmh-FIqS0L1OyyB7hag8Zb_F8WsA2QLkMCw_4PmUDvabjw', 'zigh'),
(15, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ6aWdoOjIwMTctMTEtMDEgMTM6NTU6MDE_d2Vla2VuZC1NYVl6a1NqbWt6UEM1N0xQT1NQRUpSTFhMU01aS0pka3NxZDU0NTQtSUQiLCJhdWQiOiJ3ZWIiLCJleHAiOjE1MDk2NDE4MDUsImlhdCI6MTUwOTU0MTAwNX0.tZVFCJ0vNCDcjBNLLRl3ye_y3d8qYhA0pCOShTu6DdjyKGzxlxIp5ongECCyg3FOXcnwF-d13x0JTduJ2yooeQ', 'zigh'),
(16, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ6aWdoOjIwMTctMTEtMDEgMTU6MzA6NTI_d2Vla2VuZC1NYVl6a1NqbWt6UEM1N0xQT1NQRUpSTFhMU01aS0pka3NxZDU0NTQtSUQiLCJhdWQiOiJ3ZWIiLCJleHAiOjE1MDk2NDc0NTIsImlhdCI6MTUwOTU0NjY1Mn0.n4kXHB6oPMgbuXPf2t6xw9DMXBlP9jtd5lO6lbrXdjqD-e59LZQi_XOwd6JyVlfv42bWvJ9XaHu7hElu5l9swA', 'zigh');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `identifier` bigint(20) NOT NULL,
  `country` varchar(255) DEFAULT NULL,
  `lattitude` varchar(255) DEFAULT NULL,
  `local_time` varchar(255) DEFAULT NULL,
  `localtimeEpoch` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `tzId` varchar(255) DEFAULT NULL,
  `available_activity_fk` bigint(20) DEFAULT NULL,
  `weather_fk` bigint(20) DEFAULT NULL,
  `location` bigint(20) DEFAULT NULL,
  `result` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `t_condition`
--

CREATE TABLE `t_condition` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_resource` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `t_current`
--

CREATE TABLE `t_current` (
  `identifier` bigint(20) NOT NULL,
  `cloud` decimal(10,2) DEFAULT NULL,
  `feelslike_c` decimal(10,2) DEFAULT NULL,
  `humidity` decimal(10,2) DEFAULT NULL,
  `isDay` int(11) NOT NULL,
  `last_updated_epoch` bigint(20) DEFAULT NULL,
  `last_updated` varchar(255) DEFAULT NULL,
  `precip_mm` decimal(10,2) DEFAULT NULL,
  `pressure_mb` decimal(10,2) DEFAULT NULL,
  `temp_c` decimal(10,2) DEFAULT NULL,
  `wind_degree` decimal(10,2) DEFAULT NULL,
  `wind_dir` varchar(255) DEFAULT NULL,
  `wind_kph` decimal(10,2) DEFAULT NULL,
  `condition_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `identifier` bigint(20) NOT NULL,
  `deletion_code` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `validated_mail` bit(1) DEFAULT NULL,
  `favourite_location_fk` bigint(20) DEFAULT NULL,
  `result` int(11) NOT NULL,
  `validation_code` varchar(21) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`identifier`, `deletion_code`, `email`, `password`, `username`, `validated_mail`, `favourite_location_fk`, `result`, `validation_code`) VALUES
(1, NULL, 'zigh@ino', 'ed2f6a16309083340dc55002c80ed290', 'zigh', b'0', NULL, 1082258350, NULL),
(2, NULL, 'poupoule@ino', '2334f1bf147d0c92a07f55eccacacc49', 'mouma', b'0', NULL, 0, NULL),
(3, NULL, 'a@s', '9fbc0a28fc2252bb03d681ac95453a5f', 'amazigh', b'0', NULL, 0, NULL),
(6, NULL, 'cherie@moi', 'ed2f6a16309083340dc55002c80ed290', 'cherie', b'0', NULL, 0, NULL),
(26, NULL, 'hkebaili92@gmail.com', 'f4026e02ba38fb51cb5288fef10e4793', 'test1', b'1', NULL, 0, '231044323884515260432'),
(27, NULL, 'djebarri.amazigh@gmail.com', 'd099286fb13356769fe816d543fd6d42', 'jetaimepoupoule', b'0', NULL, 0, '303586376782277542206'),
(28, NULL, 'toto@toto', 'd28743669931c69f631c10ab8e7186eb', 'goku', b'0', NULL, 0, '116586152384811505744'),
(29, NULL, 'l@o', 'd28743669931c69f631c10ab8e7186eb', 'amaz', b'0', NULL, 0, '242086477228803577630'),
(30, NULL, 'qs@o', '80a43118e9388ecc3dfe261be201440f', 'qsqs', b'0', NULL, 0, '020802682535360662612'),
(31, NULL, 's@o', 'af83c359a3491eb3263bcb19ebb3e26b', 'qsdqsd', b'0', NULL, 0, '826672714606147545348'),
(32, NULL, 'l@os', 'd28743669931c69f631c10ab8e7186eb', 'lolo', b'0', NULL, 0, '280183117354320216844'),
(33, NULL, 'p@o', '92dab10d957e4bb42c7655389c919213', 'pour', b'0', NULL, 0, '822823416582461275364'),
(34, NULL, 'o@s', 'd28743669931c69f631c10ab8e7186eb', 'hakima', b'0', NULL, 0, '660830416001884636574'),
(35, NULL, 'amazi@s', 'd28743669931c69f631c10ab8e7186eb', 'qsdsd', b'0', NULL, 0, '322815783416400546581'),
(43, NULL, 'dss@p', '36052af5ce36381f5b94f0431258b61c', 'dsss', b'0', NULL, -1106836350, '575347183231415462075'),
(44, NULL, 'pa@s', 'd28743669931c69f631c10ab8e7186eb', 'oppa', b'0', NULL, 0, '810236481530131568524'),
(45, NULL, 'p@si', '8a4059cd4a39145650d56e3be989ce01', 'pipouye', b'0', NULL, 0, '687064623368554631308'),
(46, NULL, 'azeze@s', '09c4dbd7c1fe152b95464cddb90102c5', 'opoe', b'0', NULL, 0, '411558022813575246332'),
(47, NULL, 'qn@k', 'f3bf45afdd9af5780694e9b2911ef2d4', 'qsqSQS', b'0', NULL, 966168265, '183460673125072430743'),
(48, NULL, 'm@k', 'f3bf45afdd9af5780694e9b2911ef2d4', 'pzzaz', b'0', NULL, 0, '762382874378450727715'),
(49, NULL, 'x@l', '4d02194f88916068c0b238360ca16468', 'qsdqsda', b'0', NULL, 0, '631361527804368812482'),
(50, NULL, 'p@za', 'd28743669931c69f631c10ab8e7186eb', 'amazz', b'0', NULL, 0, '014520158451531457134'),
(51, NULL, 'x@lz', '8ef4712dd2c485782d13a4dbda3e3172', 'ssqqsq', b'0', NULL, 0, '374864226022234844323');

-- --------------------------------------------------------

--
-- Table structure for table `weather`
--

CREATE TABLE `weather` (
  `id` bigint(20) NOT NULL,
  `current` bigint(20) DEFAULT NULL,
  `location` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activity`
--
ALTER TABLE `activity`
  ADD PRIMARY KEY (`identifier`);

--
-- Indexes for table `adequate_activities_weather`
--
ALTER TABLE `adequate_activities_weather`
  ADD PRIMARY KEY (`identifier`),
  ADD KEY `FK_rodwpeuy17w7avh0wo9mu98ba` (`adequate_weather`);

--
-- Indexes for table `favourite_activities`
--
ALTER TABLE `favourite_activities`
  ADD PRIMARY KEY (`identifier`),
  ADD KEY `FK_sgut6qj9nna9lmwmx9jmpcvws` (`activity_fk`),
  ADD KEY `FK_p9h25q7jevj6w4tl8bgoajuf` (`user_fk`);

--
-- Indexes for table `favourite_location`
--
ALTER TABLE `favourite_location`
  ADD PRIMARY KEY (`identifier`),
  ADD KEY `FK_eq6qijdoibqllsrh8kvmar7ou` (`location_fk`),
  ADD KEY `FK_ksrwl0u4hj3jc4qr4ce07fwhl` (`user_fk`);

--
-- Indexes for table `invalid_tokens`
--
ALTER TABLE `invalid_tokens`
  ADD PRIMARY KEY (`identifier`),
  ADD UNIQUE KEY `UK_qem1f1vwrgc09i760xx5cglgx` (`value`),
  ADD KEY `FK_ajel4bl7opr3r8uya6sb8yc1` (`user_username`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`identifier`),
  ADD KEY `FK_se17aectqcivkknbvk9yeohu9` (`available_activity_fk`),
  ADD KEY `FK_6r9ji0hfshqh3abvojq6b1ek0` (`weather_fk`),
  ADD KEY `FK_59y48akrkev8c1oppq052b5ex` (`location`);

--
-- Indexes for table `t_condition`
--
ALTER TABLE `t_condition`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t_current`
--
ALTER TABLE `t_current`
  ADD PRIMARY KEY (`identifier`),
  ADD KEY `FK_imhbs85luqvu4wx93ex8fo5vv` (`condition_fk`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`identifier`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  ADD UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
  ADD KEY `FK_8w3bnsnj73c46v395faxuummg` (`favourite_location_fk`);

--
-- Indexes for table `weather`
--
ALTER TABLE `weather`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_dmjaoe2pc5327n1ousdr03fgr` (`current`),
  ADD KEY `FK_jdl26mlsyf29s89gh28vlh4bm` (`location`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `activity`
--
ALTER TABLE `activity`
  MODIFY `identifier` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `adequate_activities_weather`
--
ALTER TABLE `adequate_activities_weather`
  MODIFY `identifier` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `favourite_activities`
--
ALTER TABLE `favourite_activities`
  MODIFY `identifier` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `favourite_location`
--
ALTER TABLE `favourite_location`
  MODIFY `identifier` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `invalid_tokens`
--
ALTER TABLE `invalid_tokens`
  MODIFY `identifier` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `identifier` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `t_condition`
--
ALTER TABLE `t_condition`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `t_current`
--
ALTER TABLE `t_current`
  MODIFY `identifier` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `identifier` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
--
-- AUTO_INCREMENT for table `weather`
--
ALTER TABLE `weather`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `adequate_activities_weather`
--
ALTER TABLE `adequate_activities_weather`
  ADD CONSTRAINT `FK_rodwpeuy17w7avh0wo9mu98ba` FOREIGN KEY (`adequate_weather`) REFERENCES `activity` (`identifier`);

--
-- Constraints for table `favourite_activities`
--
ALTER TABLE `favourite_activities`
  ADD CONSTRAINT `FK_p9h25q7jevj6w4tl8bgoajuf` FOREIGN KEY (`user_fk`) REFERENCES `user` (`identifier`),
  ADD CONSTRAINT `FK_sgut6qj9nna9lmwmx9jmpcvws` FOREIGN KEY (`activity_fk`) REFERENCES `activity` (`identifier`);

--
-- Constraints for table `favourite_location`
--
ALTER TABLE `favourite_location`
  ADD CONSTRAINT `FK_eq6qijdoibqllsrh8kvmar7ou` FOREIGN KEY (`location_fk`) REFERENCES `location` (`identifier`),
  ADD CONSTRAINT `FK_ksrwl0u4hj3jc4qr4ce07fwhl` FOREIGN KEY (`user_fk`) REFERENCES `user` (`identifier`);

--
-- Constraints for table `invalid_tokens`
--
ALTER TABLE `invalid_tokens`
  ADD CONSTRAINT `FK_ajel4bl7opr3r8uya6sb8yc1` FOREIGN KEY (`user_username`) REFERENCES `user` (`username`);

--
-- Constraints for table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `FK_59y48akrkev8c1oppq052b5ex` FOREIGN KEY (`location`) REFERENCES `activity` (`identifier`),
  ADD CONSTRAINT `FK_6r9ji0hfshqh3abvojq6b1ek0` FOREIGN KEY (`weather_fk`) REFERENCES `weather` (`id`),
  ADD CONSTRAINT `FK_se17aectqcivkknbvk9yeohu9` FOREIGN KEY (`available_activity_fk`) REFERENCES `activity` (`identifier`);

--
-- Constraints for table `t_current`
--
ALTER TABLE `t_current`
  ADD CONSTRAINT `FK_imhbs85luqvu4wx93ex8fo5vv` FOREIGN KEY (`condition_fk`) REFERENCES `t_condition` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_8w3bnsnj73c46v395faxuummg` FOREIGN KEY (`favourite_location_fk`) REFERENCES `favourite_location` (`identifier`);

--
-- Constraints for table `weather`
--
ALTER TABLE `weather`
  ADD CONSTRAINT `FK_dmjaoe2pc5327n1ousdr03fgr` FOREIGN KEY (`current`) REFERENCES `t_current` (`identifier`),
  ADD CONSTRAINT `FK_jdl26mlsyf29s89gh28vlh4bm` FOREIGN KEY (`location`) REFERENCES `location` (`identifier`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
