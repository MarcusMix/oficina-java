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


DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `id` int not null auto_increment,
  `nome` varchar(60) DEFAULT NULL,
  `rg` varchar(25) DEFAULT NULL,
  `cpf` varchar(25) DEFAULT NULL,
  `rua` varchar(100) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(60) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  `cep` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `fone1` varchar(15) DEFAULT NULL,
  `fone2` varchar(15) DEFAULT NULL,
  `obs` varchar(1500) DEFAULT NULL,
  `nascimento` date DEFAULT NULL,
  `datacadastro` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  KEY `clientes_id_IDX` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'SOLIMAR ALBRECHT LOPES','4400501','74809571068','JOPSE FERMIONO','PRADO DE BAIXO','BIGUAÇU','SC','88160016','SOLIMAR.LOPES','44','489999999','teste','1976-07-19','2021-03-27'),(3,'SDFASDF','74809571068','74809571068',NULL,NULL,NULL,NULL,NULL,NULL,'RRRR',NULL,NULL,NULL,'2021-03-27'),(5,'DSFGDFGRRR','74809571068','74809571068',NULL,NULL,NULL,NULL,NULL,NULL,'ASDFASDF',NULL,NULL,NULL,'2021-03-27'),(6,'AAA','AAA','aaa','AAA','AAA','AAA','AA','AAA','AAA','AAA','AAA',NULL,'2015-10-10','2021-03-27'),(7,'AAA','AAA','aaal','AAA','AAA','AAA','AA','AAA','AAAA','AAA','AAA',NULL,'2005-10-10','2021-03-27'),(8,'ANA MARIA BRAGA','44400105','7777777','DAS ANTILHAS 55','CENTRO','SANTOS','SP','88160000','SOLIMAR.LOPES@GMAIL.COM','48 -327113132',NULL,'teste','1976-07-19','2021-03-27'),(9,'JOSE DA SILVA ','888','888','RUA DOS INGAS 55','CENTRO','SANTOS','SP','88110000','JOPSE@FAMILIAR.COM','11 99941454',NULL,'teste','2022-10-01','2021-03-27'),(10,'GALVÃO BOENO MACHADO','5555','555','RUA DOS IPÊS 22','CENTRO ','SÃO SEBASTIÃO','SP','22222','GUEDES@COVID.COM','11 663366',NULL,'dfsdf','2020-10-10','2021-03-27'),(11,'EEEE','EEE','eeee','EEE','EE','EE','EE','4444','444','44444444444','44444444444','eee','2020-10-10','2021-03-28'),(12,'SOLIMAR ALBRECHT LOPES','4400501','84809571068','JOSÉ FERMINO MARÇAL 263','PRADO DE BAIXO','BIGUAÇU','SC','88160016','SOLIMAR.LOPES@GMAIL.COM','48996787740','4830360666','cliente desde 2005','1976-07-19','2021-03-28'),(13,'VALERIA LOPES','4400','01036064913',NULL,NULL,NULL,NULL,NULL,NULL,'4830360666',NULL,NULL,NULL,'2021-03-28'),(14,'TICATAC',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'ANA MARIA DA SILVA','4400501','5555555555','DAS ANTILHAS 55','CENTRO','SANTOS','SP','88160006','ANA@ANA.COM','4832711313',NULL,NULL,NULL,'2021-06-01'),(16,'JAIR MESSIAS BOLSONARO','123456789','123456789','DAS ANTILHAS 55','CENTRO','SANTOS','SP','88160000','BOSO@BOSO.COM.BR','55222222222',NULL,NULL,NULL,'2021-06-05');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemsvendas`
--

DROP TABLE IF EXISTS `itemsvendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemsvendas` (
  `id` int(11) DEFAULT NULL,
  `idvenda` int(11) DEFAULT NULL,
  `descricao` varchar(60) DEFAULT NULL,
  `valunit` decimal(18,2) DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `vtot` decimal(18,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemsvendas`
--

LOCK TABLES `itemsvendas` WRITE;
/*!40000 ALTER TABLE `itemsvendas` DISABLE KEYS */;
INSERT INTO `itemsvendas` VALUES (1,1,'AAA',5.00,5,25.00,0),(2,1,'BB',7.00,7,49.00,0),(1,2,'AMORTECEDOR',44.00,2,88.00,0),(1,2,'AMORTECEDOR',44.00,2,88.00,0),(3,2,'BUCHA DE CANHÃO',7.00,5,35.00,0),(4,2,'PRAFUSO SOBERBO',5.62,4,22.48,0),(1,3,'BATENTE DA PORTA',143.89,1,143.89,0),(1,4,'FILTRO DE AR',150.00,10,1500.00,0),(1,5,'LIMPADOR DE PARABRISAS',60.00,1,60.00,0),(2,5,'PARAFUSOS DA CAIXA DE CAMBIO',0.50,1,0.50,0),(3,5,'VIRABREKIM',2350.25,1,2350.25,0),(1,6,'REVISÃO GERAL PÓS VENDA CONCESSIONÁRIA',5650.55,1,5650.55,0),(1,7,'FAROL',150.00,1,150.00,0),(2,7,'VIDRO DA JANELA DIREITA',149.90,1,149.90,0),(3,7,'MAÇANETA DO VIDRO DIREITO',15.50,1,15.50,0),(1,8,'LAMPADA TRASEIRA1',10.00,1,10.00,0),(4,7,'BORRACHA DE VEDAÇÃO DA TAMPA DO MOTOR',250.00,1,250.00,0),(5,7,'MÃO DE OBRA',1580.60,1,1580.60,0);
/*!40000 ALTER TABLE `itemsvendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profissionais`
--

DROP TABLE IF EXISTS `profissionais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profissionais` (
  `id` int not null auto_increment,
  `nome` varchar(60) DEFAULT NULL,
  `RG` varchar(25) DEFAULT NULL,
  `cpf` varchar(25) DEFAULT NULL,
  `rua` varchar(50) DEFAULT NULL,
  `bairro` varchar(25) DEFAULT NULL,
  `cidade` varchar(30) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  `cep` varchar(25) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `fone1` varchar(25) DEFAULT NULL,
  `fone2` varchar(25) DEFAULT NULL,
  `cargo` varchar(50) DEFAULT NULL,
  `nascimento` date default null,
  `admissao` date DEFAULT NULL,
  `funcao` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profissionais`
--

LOCK TABLES `profissionais` WRITE;
/*!40000 ALTER TABLE `profissionais` DISABLE KEYS */;
INSERT INTO `profissionais` VALUES (1,'ADEMIR DA SILVA','4400','111111','DAS CARMELIAS 55','CENTRO','SÃO SEBASTIÃO','SP','881600000','SSS',NULL,NULL,NULL,NULL,NULL),(2,'CUSTROMILDO DA SILVA','222','222','222','222','222','22','222','2222','4832711313',NULL,NULL,NULL,NULL),(3,'MODELO GERAÇÕES LTDA','63333','3333','33','33','33','33','333','33','33333333333','33333333333','333','2025-01-01','33333'),(4,'YYYYYLL','YYYY','YYYY','YY','YY','YY','YY','6666','YY','66666666666','66666666666','666','2023-10-10','YYYYY'),(5,'AEROSOL CLINICALR','4400','4400',NULL,NULL,NULL,NULL,NULL,NULL,'48222222222',NULL,NULL,NULL,NULL),(6,'<SEM DEFINIÇÃO>',NULL,'00000000',NULL,NULL,NULL,NULL,NULL,NULL,'00000000000',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `profissionais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendasos`
--

DROP TABLE IF EXISTS `vendasos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendasos` (
  `id` int(11) DEFAULT NULL,
  `categoria` int(11) DEFAULT NULL,
  `datacad` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `cliente` int(11) DEFAULT NULL,
  `observacoes` varchar(1000) DEFAULT NULL,
  `valortotal` decimal(18,2) DEFAULT NULL,
  `tipopag` varchar(35) DEFAULT NULL,
  `condicaopag` varchar(35) DEFAULT NULL,
  `profissional` int(11) DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL,
  `dataaprovaorca` date DEFAULT NULL,
  `datafim` date DEFAULT NULL,
  `valorpago` decimal(18,2) DEFAULT NULL,
  `desconto` decimal(18,2) DEFAULT NULL,
  `veiculo` varchar(40) DEFAULT NULL,
  `placa` varchar(40) DEFAULT NULL,
  `km` varchar(40) DEFAULT NULL,
  `chassi` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendasos`
--

LOCK TABLES `vendasos` WRITE;
/*!40000 ALTER TABLE `vendasos` DISABLE KEYS */;
INSERT INTO `vendasos` VALUES (1,NULL,'2021-03-28','22:35:10',13,'aa',NULL,'Dinheiro','1X',6,'Orçamento',NULL,NULL,NULL,NULL,'AAAA','AA','AA','AA'),(2,NULL,'2021-06-01','09:31:23',9,NULL,NULL,'Dinheiro','1X',1,'Orçamento',NULL,NULL,NULL,NULL,'FIAT UNO ','JTP4781','250000','00000111'),(3,NULL,'2021-06-01','09:58:39',9,NULL,NULL,'Dinheiro','1X',1,'Orçamento',NULL,NULL,NULL,NULL,'FIAT UNO MILHO','JTP4781','200','20000'),(4,NULL,'2021-06-05','11:10:29',13,NULL,1500.00,'Dinheiro','1X',1,NULL,NULL,NULL,1000.00,500.00,'FIAT UNO MILLE','JTP4781','250000','SDFASDF'),(5,NULL,'2021-06-05','13:23:51',13,NULL,2410.75,'Dinheiro','1X',1,'Orçamento',NULL,NULL,2000.00,410.75,'SANTANA 2000','AKJ 3878','20000','1111'),(6,NULL,'2021-06-05','13:31:40',16,'UUUUUUUUUUUUUUUUUUUU',NULL,'Dinheiro','1X',1,'Orçamento',NULL,NULL,NULL,NULL,'VAN PRESIDENCIAL','PRES123456789','0','PRESI222'),(7,NULL,'2021-06-05','14:10:08',13,NULL,2146.00,'Dinheiro','8X',5,'Orçamento',NULL,NULL,2000.00,146.00,'CAMIONETE ','FOCA123456','10','1111'),(8,NULL,'2021-06-05','14:46:33',13,NULL,10.00,'Dinheiro','1X',2,'Ordem de Serviç',NULL,NULL,10.00,NULL,'BLAZER ','MKF13131','1000','100');
/*!40000 ALTER TABLE `vendasos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'oficina1'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-08  8:24:55