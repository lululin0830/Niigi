CREATE DATABASE IF NOT EXISTS GP;
USE GP;

DROP TABLE IF EXISTS NotificationModel;
DROP TABLE IF EXISTS SortWeight;
DROP TABLE IF EXISTS Advertise;
DROP TABLE IF EXISTS AdSpace;
DROP TABLE IF EXISTS MemberPointsRecord;
DROP TABLE IF EXISTS SubOrderDetail;
DROP TABLE IF EXISTS SubOrder;
DROP TABLE IF EXISTS MainOrder;
DROP TABLE IF EXISTS MemberCouponList;
DROP TABLE IF EXISTS EventApplicableProducts;
DROP TABLE IF EXISTS EventSingleThreshold;
DROP TABLE IF EXISTS ShelvesStatusRecord;
DROP TABLE IF EXISTS RestockRecord;
DROP TABLE IF EXISTS ProductSpec;
DROP TABLE IF EXISTS Product;
DROP TABLE IF EXISTS FrontendPage;
DROP TABLE IF EXISTS Categorie;
DROP TABLE IF EXISTS Blacklist;
DROP TABLE IF EXISTS AccountSuspendRecord;
DROP TABLE IF EXISTS SupplierMember;
DROP TABLE IF EXISTS `Suppliers`;
DROP TABLE IF EXISTS `Users`;
DROP TABLE IF EXISTS `Members`;

-- 會員資料表
CREATE TABLE `Members` (
  memberId CHAR(10) comment'會員編號' primary key,
  memberAcct VARCHAR(50) not null comment'會員帳號' unique,
  `password` VARCHAR(600) not null comment'密碼',
  phone CHAR(12) not null comment'手機',
  `name` VARCHAR(20) not null comment'姓名',
  gender ENUM('0','1') not null comment'性別:0是男1是女',
  birthday DATE not null comment'生日',
  memPhoto LONGBLOB comment'會員圖片',
  memPointBalance INT default(0) comment'會員點數餘額',
  memPointMinExp date comment'會員點數最短有效期限',
  creditNum CHAR(16) unique comment'信用卡卡號',
  creditExp CHAR(4) comment'卡片有效期限',
  cvv CHAR(3) comment '安全碼',
  cardholder VARCHAR(20) comment '持卡人',
  regTime TIMESTAMP default(now()) comment'註冊時間',
  banStatus ENUM('0','1','3','7','30') default('0') comment'停權狀態：0正常,1永久停權,3停權三天,7停權7天,30停權30天',
  backupEmail VARCHAR(50) comment'備用信箱帳號',
  memberAddress VARCHAR(50) comment'地址',
  lastRecipient VARCHAR(20) comment'常用收件人',
  lastPhoneNum CHAR(12) comment'常用手機',
  lastDeliveryAddress VARCHAR(100) comment'常用地址',
  regStatusOpen ENUM('0','1') default('0') comment'註冊開通狀態：0未開通,1開通',
  backupStatusOpen ENUM('0','1') default('0') comment'備用信箱開通狀態：0未開通,1開通'
  )comment '會員資料表';
  
INSERT INTO `Members` (memberId, memberAcct, `password`, phone, `name`, gender, birthday, memPointBalance, memPointMinExp, creditNum, creditExp, cvv, cardholder, regTime, banStatus, backupEmail, memberAddress, lastRecipient, lastPhoneNum, lastDeliveryAddress, regStatusOpen, backupStatusOpen)
VALUES
('M000000001', 'john@example.com', 'password123', '0912-345-678', '張三', '0', '1990-01-01', FLOOR(RAND()*900)+100, '2023-8-31', '1234567812345678', '1025', '123', 'WANG, SIAO-MING', NOW(), '0', 'backup1@example.com', '104 台北市 中山區 南京東路三段219號5樓', '王小美', '0987-654-321', '104 台北市 中山區 南京東路三段219號5樓', '1', '1'),
('M000000002', 'mary@example.com', 'password456', '0922-345-678', '李四', '1', '1995-05-15', FLOOR(RAND()*900)+100, '2023-8-14', '2345678923456789', '1025', '456', 'LEE, YUAN-HUA', NOW(), '0', 'backup2@example.com', '104 台北市 中山區 南京東路三段219號5樓', '張小明', '0912-987-654', '104 台北市 中山區 南京東路三段219號5樓', '1', '1'),
('M000000003', 'alice@example.com', 'password789', '0933-345-678', '張無忌', '0', '1988-11-20', FLOOR(RAND()*900)+100, '2023-8-13', '3456789134567891', '0225', '789', 'ZHANG, WUJI', NOW(), '0', 'backup3@example.com', '104 台北市 中山區 南京東路三段219號5樓', '陳小琳', '0988-123-456', '104 台北市 中山區 南京東路三段219號5樓', '1', '1'),
('M000000004', 'david@example.com', 'password123456', '0944-345-678', '李小龍', '1', '1975-07-15', FLOOR(RAND()*900)+100, '2023-8-1', '4567891245678912', '0425', '321', 'LI, XIAOLONG', NOW(), '0', 'backup4@example.com', '104 台北市 中山區 南京東路三段219號5樓', '林小美', '0955-987-654', '104 台北市 中山區 南京東路三段219號5樓', '1', '1'),
('M000000005', 'sarah@example.com', 'password987654', '0955-345-678', '王五', '0', '1980-12-25', FLOOR(RAND()*900)+100, '2023-8-20', '5678912356789123', '1025', '987', 'WANG, WU', NOW(), '0', 'backup5@example.com', '104 台北市 中山區 南京東路三段219號5樓', '劉小寶', '0966-123-456', '104 台北市 中山區 南京東路三段219號5樓', '1', '1'),
('M000000006', 'jane@example.com', 'password234567', '0966-345-678', '陳芳', '1', '1992-08-10', FLOOR(RAND()*900)+100, '2023-8-22', '6789123467891234', '0728', '234', 'CHEN, FANG', NOW(), '0', 'backup6@example.com', '104 台北市 中山區 南京東路三段219號5樓', '張小華', '0977-987-654', '104 台北市 中山區 南京東路三段219號5樓', '1', '1'),
('M000000007', 'peter@example.com', 'password345678', '0977-345-678', '李大', '0', '1985-06-05', FLOOR(RAND()*900)+100, '2023-8-21', '7891234578912345', '1129', '345', 'LI, DA', NOW(), '0', 'backup7@example.com', '104 台北市 中山區 南京東路三段219號5樓', '王小強', '0988-123-456', '104 台北市 中山區 南京東路三段219號5樓', '1', '1'),
('M000000008', 'emily@example.com', 'password456789', '0988-345-678', '劉靜', '1', '1998-04-18', FLOOR(RAND()*900)+100, '2023-8-11', '8912345689123456', '1227', '456', 'LIU, JING', NOW(), '0', 'backup8@example.com', '104 台北市 中山區 南京東路三段219號5樓', '陳小華', '0999-987-654', '104 台北市 中山區 南京東路三段219號5樓', '1', '1'),
('M000000009', 'tom@example.com', 'password567890', '0999-345-678', '張小強', '0', '1993-09-30', FLOOR(RAND()*900)+100, '2023-8-31', '9123456791234567', '1227', '567', 'ZHANG, XIAOQIANG', NOW(), '0', 'backup9@example.com', '104 台北市 中山區 南京東路三段219號5樓', '王小明', '0912-123-456', '104 台北市 中山區 南京東路三段219號5樓', '1', '1'),
('M000000010', 'jeff@example.com', 'password1234', '0919-345-678', '王寶強', '0', '1993-11-30', FLOOR(RAND()*900)+100, '2023-8-2', '9123456791234321', '1225', '517', 'WANG,BAO-CIANG', NOW(), '0', 'backup10@example.com', '104 台北市 中山區 南京東路三段219號5樓', '王小明', '0912-123-456', '104 台北市 中山區 南京東路三段219號5樓', '1', '1'),
('M000000011', 'jeffrey821537@gmail.com', 'password01', '0988-526-875', '陳柏維', '0', '1995-02-08', FLOOR(RAND()*900)+100, '2023-8-2', '4705380112345678', '1229', '412', 'CHEN PO-WEI', NOW(), '0', 'backup10@example.com', '104 台北市 中山區 南京東路三段219號5樓', '王小明', '0912-123-456', '104 台北市 中山區 南京東路三段219號5樓', '1', '1'),
('M000000012', 'lululin0830@gmail.com', 'password02', '0939-083-001', '林欣儒', '1', '1999-08-30', FLOOR(RAND()*900)+100, '2023-8-2', '4617760212345678', '1027', '321', 'LIN SIN-RU', NOW(), '0', 'backup10@example.com', '104 台北市 中山區 南京東路三段219號5樓', '王小明', '0912-123-456', '104 台北市 中山區 南京東路三段219號5樓', '1', '1'),
('M000000013', 'anthony963741@gmail.com', 'password03', '0921-321-123', '顏伯諺', '0', '1997-04-12', FLOOR(RAND()*900)+100, '2023-8-2', '4617760222345678', '1127', '323', 'YAN BO-YAN', NOW(), '0', 'backup10@example.com', '104 台北市 中山區 南京東路三段219號5樓', '王小明', '0912-123-456', '104 台北市 中山區 南京東路三段219號5樓', '1', '1'),
('M000000014', 'rrr150100@gmail.com', 'password04', '0921-321-123', '王雅玲', '1', '1997-03-12', FLOOR(RAND()*900)+100, '2023-8-2', '4617760222345680', '0927', '124', 'WANG YA-LING', NOW(), '0', 'backup10@example.com', '104 台北市 中山區 南京東路三段219號5樓', '王小明', '0912-123-456', '104 台北市 中山區 南京東路三段219號5樓', '1', '1'),
('M000000015', 'davida56254@gmail.com', 'password05', '0921-123-456', '呂大為', '0', '1997-07-13', FLOOR(RAND()*900)+100, '2023-8-2', '4617760212345679', '1128', '313', 'LU DA-WEI', NOW(), '0', 'backup10@example.com', '104 台北市 中山區 南京東路三段219號5樓', '王小明', '0912-123-456', '104 台北市 中山區 南京東路三段219號5樓', '1', '1'),
('M000000016', 'jocker10113@gmail.com', 'password06', '0921-123-678', '廖韋豪', '0', '1999-05-13', FLOOR(RAND()*900)+100, '2023-8-2', '4617760212345681', '1228', '613', 'LIAO WEI-HAO', NOW(), '0', 'backup10@example.com', '104 台北市 中山區 南京東路三段219號5樓', '王小明', '0912-123-456', '104 台北市 中山區 南京東路三段219號5樓', '1', '1');
  
-- 平台使用者
CREATE TABLE `Users` (
  userId INT auto_increment comment'使用者編號' primary key,
  userName VARCHAR(15) not null comment'使用者名稱',
  userAcct VARCHAR(15) not null comment'使用者帳號',
  `password` VARCHAR(600) not null comment'密碼',
  financialAuthority ENUM('0','1') default('0') comment'財務權限',
  customerServiceAuthority ENUM('0','1') default('0') comment'客服權限',
  marketingAuthority ENUM('0','1') default('0') comment'行銷權限',
  hrAuthority ENUM('0','1')  default('0') comment'人事權限'
)auto_increment=10001 comment '平台使用者';

INSERT INTO `Users` (userName, userAcct, `password`, financialAuthority, customerServiceAuthority, marketingAuthority, hrAuthority)
VALUES
('jeffrey', 'jeffrey', 'password01', '1', '1', '1', '1'),
('lulu', 'lulu', 'password02', '1', '1', '1', '1'),
('josh', 'josh', 'password03', '1', '1', '1', '1'),
('david', 'david', 'password04', '1', '1', '1', '1'),
('joker', 'joker', 'password05', '1', '1', '1', '1'),
('rrr', 'rrr', 'password06', '1', '1', '1', '1'),
('John Doe', 'john', 'password123', '1', '0', '0', '0'),
('Mary Smith', 'mary', 'password456', '0', '1', '0', '0'),
('David Johnson', 'david', 'password789', '0', '0', '1', '0'),
('Sarah Brown', 'sarah', 'password123456', '0', '0', '0', '1');

-- 商家資料表
CREATE TABLE `Suppliers` (
  `supplierId` CHAR(10) COMMENT '商家編號',
  `supplierMemberAcct` VARCHAR(50) NOT NULL COMMENT '商家帳號',
  `businessId` CHAR(8) COMMENT '統一編號',
  `ownerId` CHAR(10) NOT NULL COMMENT '負責人身份證字號',
  `supplierAddress` VARCHAR(200) NOT NULL COMMENT '負責人戶籍地址',
  `bankCode` CHAR(3) NULL COMMENT '銀行代碼',
  `bankAcct` CHAR(14) NOT NULL COMMENT '銀行帳戶',
  `shopName` VARCHAR(50) COMMENT '商店名稱',
  `shopInfo` VARCHAR(200) COMMENT '商店說明',
  `logo` LONGBLOB COMMENT '商店LOGO',
  `shopBackground` LONGBLOB COMMENT '商店背景圖片',
  `supplierBanStatus` ENUM('0', '1', '3', '7', '30') default('0') COMMENT '商家狀態：0正常,1永久停權,3停權3天,7停權7天,30停權30天', 
  `shopVacation` ENUM('0', '1') default('0') COMMENT '商家休假',
  `vacationStart` DATE COMMENT '休假起始日',
  `vacationEnd` DATE COMMENT '休假結束日',
  `pauseOrderAcceptance` ENUM('0', '1') default('0') COMMENT '暫停接單：0正常,1暫停',
  `pauseShipping` ENUM('0', '1') default('0') COMMENT '暫停出貨：0正常,1暫停',
  `pauseNotification` ENUM('0', '1') default('0') COMMENT '暫停通知： 0正常,1暫停',
  `approvalStatus` ENUM('0', '1') default('0') COMMENT '審核狀態：0通過,1不通過',
  `approvalRemark` VARCHAR(150) COMMENT '審核備註',
  `enableTime` TIMESTAMP default(NOW()) COMMENT '開通時間',
  `grossProfitRatio` DECIMAL(3, 2) default(0.15) COMMENT '毛利率',
  `pointRewardsRatio` DECIMAL(4, 3) default(0.005) COMMENT '會員點數回饋比例',
  PRIMARY KEY (`supplierId`),
  UNIQUE KEY `UK_Supplier_supplierMemberAcct` (`supplierMemberAcct`),
  UNIQUE KEY `UK_Supplier_businessId` (`businessId`)
) COMMENT '商家資料表';


INSERT INTO `Suppliers` (supplierId, supplierMemberAcct, businessId, ownerId, supplierAddress, bankCode, bankAcct, shopName, shopInfo, logo, shopBackground,approvalStatus, approvalRemark, enableTime)
VALUES
('S000000001', 'lululin0830@gmail.com', '12868358', 'A222212345', '104 台北市 中山區 南京東路三段219號5樓', '004', '142004254382', 'THE BEST', 'High Quality', NULL, NULL,'0', NULL, '2023-05-05 00:00:00'),
('S000000002', 'anthony963741@gmail.com', '24708053', 'A123456789', '104 台北市 中山區 南京東路三段219號5樓', '833', '87273837489506', '好好買', '應有盡有', NULL, NULL,'0', NULL, '2023-05-05 00:00:00'),
('S000000003', 'davida56254@gmail.com', NULL , 'U22386098', '709 臺南市安南區館安一路28號', '566', '39586094886748', '買多多', 'VERY GOOD', NULL, NULL,'0', NULL, '2023-06-05 00:00:00'),
('S000000004', 'jane@example.com', '02935677', 'D221184906', '974 花蓮縣壽豐鄉豐富街32號', '456', '34356654908', '露得輕', '露營用品專賣', NULL, NULL,'0', NULL, '2023-06-05 00:00:00'),
('S000000005', 'david@example.com', '67345723', 'Q124857667', '325 桃園市龍潭區向陽二街20號', '346', '726458699345', 'DREAMER', 'SLEEPING...', NULL, NULL,'0', NULL, '2023-06-05 00:00:00'),
('S000000006', 'jeff@example.com', '23454398', 'Y126654098', '905 屏東縣里港鄉茄苳路3號', '012', '37775883998760', 'WHY東西', 'BAD', NULL, NULL,'0', NULL, '2023-07-05 00:00:00'),
('S000000007', 'mary@example.com', '65748339', 'F220495193', '522 彰化縣田尾鄉新生路14號', '002', '395857764849', 'CHOO', '優質母嬰用品',  NULL, NULL,'0', NULL, '2023-07-05 00:00:00'),
('S000000008', 'sarah@example.com', '63544001', 'W123374960', '237 新北市三峽區學府路3號', '083', '377850069372', '今拾糖', '進口文具用品',  NULL, NULL,'0', NULL, '2023-07-05 00:00:00'),
('S000000009', 'emily@example.com', NULL, 'S228576698', '335 桃園市大溪區打鐵寮路19號', '523', '3857768874532', 'LET ME IN', 'NOOOOO世界名著', NULL, NULL,'0', NULL, '2023-05-05 00:00:00'),
('S000000010', 'alice@example.com', '88475682', 'O126684735', '401 臺中市東區富榮街15號', '004', '46598698385856', 'HANG FIVE', '平價服飾', NULL, NULL,'0', NULL, '2023-05-05 00:00:00');

-- 商家成員
CREATE TABLE `SupplierMember` (
  `supplierId` CHAR(10) comment '商家編號',
  `memberId` CHAR(10) comment'會員編號',
  `financialAuthority` ENUM('0','1') comment'財務權限',
  `logisticsAuthority` ENUM('0','1') comment'後勤權限',
  `marketingAuthority` ENUM('0','1') comment'行銷權限',
  `hrAuthority` ENUM('0','1') comment'人事權限',
  `supplierOwner` ENUM('0','1') comment'帳戶擁有者',
  `joinDate` DATE DEFAULT (NOW()) comment'加入時間',
  PRIMARY KEY (`memberId`, `supplierId`),
  CONSTRAINT FK_SupplierMember_supplierId FOREIGN KEY (`supplierId`) REFERENCES `Supplier` (`supplierId`),
  CONSTRAINT FK_SupplierMember_memberId FOREIGN KEY (`memberId`) REFERENCES `Member` (`memberId`)
);

-- 用戶停權紀錄(商家停權為停止擁有者的權限)
CREATE TABLE AccountSuspendRecord (
  accountSuspendId INT auto_increment PRIMARY KEY comment'停權事件編號',
  memberId CHAR(10) not null comment'用戶編號',
  suspendReason VARCHAR(100) not null comment'停權原因',
  dealerUserId int not null comment'經手人(使用者編號)',
  suspendStart DATE default(NOW()) comment'停權開始時間',
  suspendEnd DATE not null comment'停權結束時間',
  suspendDuration ENUM('1','3','7','30') not null comment'停權天數：1永久停權,3停權3天,7停權7天,30停權30天',
  suspendStatusChange ENUM('1','3','7','30') comment'停權變更：1永久停權,3停權3天,7停權7天,30停權30天',
  changeUserId int comment'變更人(使用者編號)',
  constraint FK_AccountSuspendRecord_memberId foreign key (memberId) references `Member`(memberId),
  constraint FK_AccountSuspendRecord_dealerUserId foreign key (dealerUserId) references `User`(userId),
  constraint FK_AccountSuspendRecord_hangeUserId foreign key (changeUserId) references `User`(userId)
)auto_increment=1000000001 comment '用戶停權紀錄';

-- 黑名單
CREATE TABLE `Blacklist` (
  `memberId` CHAR(10) comment '商家編號',
  `supplierId` CHAR(10) comment '會員編號',
  `addTime` TIMESTAMP NOT NULL comment '加入黑名單時間',
  PRIMARY KEY (`memberId`, `supplierId`),
  CONSTRAINT FK_BlackList_supplierId FOREIGN KEY (`supplierId`) REFERENCES `Supplier` (`supplierId`),
  CONSTRAINT FK_BlackList_memberId FOREIGN KEY (`memberId`) REFERENCES `Member` (`memberId`)
) comment '黑名單';

-- 商品分類
CREATE TABLE Categorie (
  categorieId CHAR(10) not null comment '商品分類編號' PRIMARY KEY,
  categorieName VARCHAR(10) not null comment '商品分類名稱',
  mainCategorie  CHAR(10) comment '所屬商品分類',
  constraint FK_Categorie_mainCategorie foreign key (mainCategorie) references Categorie (categorieId)
) comment '商品分類';

INSERT INTO Categorie (categorieId, categorieName, mainCategorie)
VALUES
    -- 3C周邊
    ('C000000001', '3C周邊', NULL),
    ('C000000002', '手機', 'C000000001'),
    ('C000000003', '電腦', 'C000000001'),
    ('C000000004', '攝影器材', 'C000000001'),
    ('C000000005', '耳機', 'C000000001'),
    ('C000000006', '智慧家居', 'C000000001'),
    ('C000000007', '電子配件', 'C000000001'),
    ('C000000008', '遊戲周邊', 'C000000001'),
    ('C000000009', '行動電源', 'C000000001'),
    ('C000000010', '影音娛樂', 'C000000001'),
    -- 家用電器
    ('C000000011', '家用電器', NULL),
    ('C000000012', '冰箱', 'C000000011'),
    ('C000000013', '洗衣機', 'C000000011'),
    ('C000000014', '電視', 'C000000011'),
    ('C000000015', '冷氣', 'C000000011'),
    ('C000000016', '烤箱', 'C000000011'),
    ('C000000017', '吸塵器', 'C000000011'),
    ('C000000018', '咖啡機', 'C000000011'),
    ('C000000019', '電飯煲', 'C000000011'),
    ('C000000020', '電熱水壺', 'C000000011'),
    -- 美妝個清
    ('C000000021', '美妝個清', NULL),
    ('C000000022', '護膚品', 'C000000021'),
    ('C000000023', '彩妝', 'C000000021'),
    ('C000000024', '保養工具', 'C000000021'),
    ('C000000025', '香水', 'C000000021'),
    ('C000000026', '美髮工具', 'C000000021'),
    ('C000000027', '身體保養', 'C000000021'),
    ('C000000028', '美甲工具', 'C000000021'),
    ('C000000029', '沐浴用品', 'C000000021'),
    ('C000000030', '臉部清潔', 'C000000021'),
    -- 流行服飾
    ('C000000031', '流行服飾', NULL),
    ('C000000032', '男士上衣', 'C000000031'),
    ('C000000033', '女士上衣', 'C000000031'),
    ('C000000034', '男士下著', 'C000000031'),
    ('C000000035', '女士下著', 'C000000031'),
    ('C000000036', '男士外套', 'C000000031'),
    ('C000000037', '女士外套', 'C000000031'),
    ('C000000038', '男士睡衣', 'C000000031'),
    ('C000000039', '女士睡衣', 'C000000031'),
    ('C000000040', '襪子', 'C000000031'),
    -- 鞋包配飾
    ('C000000041', '鞋包配飾', NULL),
    ('C000000042', '女士包包', 'C000000041'),
    ('C000000043', '男士包包', 'C000000041'),
    ('C000000044', '女鞋', 'C000000041'),
    ('C000000045', '男鞋', 'C000000041'),
    ('C000000046', '飾品', 'C000000041'),
    ('C000000047', '皮帶', 'C000000041'),
    ('C000000048', '手錶', 'C000000041'),
    ('C000000049', '帽子', 'C000000041'),
    ('C000000050', '太陽眼鏡', 'C000000041'),
    -- 母嬰用品
    ('C000000051', '母嬰用品', NULL),
    ('C000000052', '嬰兒尿布', 'C000000051'),
    ('C000000053', '嬰兒奶瓶', 'C000000051'),
    ('C000000054', '嬰兒車', 'C000000051'),
    ('C000000055', '嬰兒床', 'C000000051'),
    ('C000000056', '嬰兒衣服', 'C000000051'),
    ('C000000057', '嬰兒餐椅', 'C000000051'),
    ('C000000058', '孕婦用品', 'C000000051'),
    ('C000000059', '嬰兒玩具', 'C000000051'),
    ('C000000060', '嬰兒益智', 'C000000051'),
    -- 日用生活
    ('C000000061', '日用生活', NULL),
    ('C000000062', '廚房用具', 'C000000061'),
    ('C000000063', '衛生用品', 'C000000061'),
    ('C000000064', '家庭清潔', 'C000000061'),
    ('C000000065', '居家裝飾', 'C000000061'),
    ('C000000066', '浴室用品', 'C000000061'),
    ('C000000067', '寢具用品', 'C000000061'),
    ('C000000068', '收納整理', 'C000000061'),
    ('C000000069', '文具用品', 'C000000061'),
    ('C000000070', '寵物用品', 'C000000061'),
    -- 圖書文具
    ('C000000071', '圖書文具', NULL),
    ('C000000072', '書籍', 'C000000071'),
    ('C000000073', '紙製品', 'C000000071'),
    ('C000000074', '書寫用具', 'C000000071'),
    ('C000000075', '檔案收納', 'C000000071'),
    ('C000000076', '事務用品', 'C000000071'),
    ('C000000077', '美術用具', 'C000000071'),
    ('C000000078', '手作用品', 'C000000071'),
    ('C000000079', '兒童文具', 'C000000071'),
    ('C000000080', '教育玩具', 'C000000071'),
    -- 旅遊戶外
    ('C000000081', '旅遊戶外', NULL),
    ('C000000082', '行李箱', 'C000000081'),
    ('C000000083', '背包', 'C000000081'),
    ('C000000084', '帳篷', 'C000000081'),
    ('C000000085', '睡袋', 'C000000081'),
    ('C000000086', '登山用具', 'C000000081'),
    ('C000000087', '釣魚用具', 'C000000081'),
    ('C000000088', '燒烤用具', 'C000000081'),
    ('C000000089', '戶外裝備', 'C000000081'),
    ('C000000090', '健身器材', 'C000000081');

-- 前台固定頁面
CREATE TABLE FrontendPage (
  pageId CHAR(10) comment '頁面編號(主鍵)' PRIMARY KEY ,
  pageName VARCHAR(15) not null comment '頁面名稱',
  pageCategorieId CHAR(10) comment '所屬商品分類(外來鍵)',
  constraint FK_Frontend_pageCategorieId foreign key (pageCategorieId) references Categorie (categorieId)
)comment '前台頁面' ;

-- 商品資料表
CREATE TABLE Product (
  productId INT auto_increment comment '商品編號(主鍵)' PRIMARY KEY,
  registerSupplier CHAR(10) not null comment '所屬商家(外來鍵)',
  categorieId CHAR(10) not null comment '商品分類編號(外來鍵)',
  productName VARCHAR(30) not null comment '商品名稱',
  productPrice INT unsigned not null comment '商品售價',
  productInfo VARCHAR(200) not null comment '商品說明',
  picture1 LONGBLOB comment '上傳圖片1',
  picture2 LONGBLOB comment '上傳圖片2',
  picture3 LONGBLOB comment '上傳圖片3',
  picture4 LONGBLOB comment '上傳圖片4',
  picture5 LONGBLOB comment '上傳圖片5',
  productStatus ENUM("0","1","2") not null comment '上架狀態：0 上架 , 1 下架 , 2 永久下架,',
  avgRating DECIMAL(2,1) comment '平均評價',
  firstOnShelvesDate DATE comment '首次上架日期',
  constraint FK_Product_registerSupplier foreign key (registerSupplier) references Supplier (supplierId),
  constraint FK_Product_categorieId foreign key (categorieId) references Categorie (categorieId)
)auto_increment=10000001 comment '商品資料表';

-- 3C周邊
INSERT INTO Product (registerSupplier, categorieId, productName, productPrice, productInfo,productStatus, avgRating, firstOnShelvesDate)
VALUES
('S000000001', 'C000000007', 'USB隨身碟', 250, '16GB儲存容量', '0',4.5, '2023-07-01'),
('S000000001', 'C000000007', '無線滑鼠', 350, '2.4GHz接收器','0', 4.2, '2023-07-02'),
('S000000001', 'C000000005', '藍牙耳機', 450, '降噪功能', '0',4.8, '2023-07-03'),
('S000000001', 'C000000009', '行動電源', 550, '10000mAh','0', 4.3, '2023-07-04'),
('S000000001', 'C000000007', '充電線', 150, '快速充電', '0',4.7, '2023-07-05'),
('S000000001', 'C000000003', '筆記型電腦', 25000, '15吋螢幕', '0',4.6, '2023-07-06'),
('S000000001', 'C000000003', '平板電腦', 15000, '10吋螢幕','0', 4.4, '2023-07-07'),
('S000000001', 'C000000007', '無線網路卡', 200, '速度快','0', 4.2, '2023-07-08'),
('S000000001', 'C000000010', '藍芽喇叭', 350, '防水設計','0', 4.7, '2023-07-09'),
('S000000001', 'C000000004', '數位相機', 4500, '20百萬畫素', '0',4.5, '2023-07-10'),
('S000000001', 'C000000002', 'iPhone 14', 28900, '最新款蘋果手機','0', 4.5, '2023-07-01'),
('S000000001', 'C000000002', 'Samsung Galaxy S21', 23900, '三星旗艦手機','0', 4.2, '2023-07-02'),
('S000000001', 'C000000002', 'Xiaomi Mi 11', 19900, '小米旗艦手機','0', 4.7, '2023-07-03'),
('S000000001', 'C000000002', 'OPPO Find X3 Pro', 26900, 'OPPO旗艦手機','0', 4.3, '2023-07-04'),
('S000000001', 'C000000002', 'OnePlus 9 Pro', 25900, '一加旗艦手機','0', 4.6, '2023-07-05');

-- 家用電器
INSERT INTO Product (registerSupplier, categorieId, productName, productPrice, productInfo,productStatus, avgRating, firstOnShelvesDate)
VALUES
('S000000002', 'C000000017', '吸塵器', 1500, '乾濕兩用', '0',4.4, '2023-07-01'),
('S000000002', 'C000000015', '冷氣機', 8000, '1.5匹冷暖型','0', 4.2, '2023-07-02'),
('S000000002', 'C000000013', '洗衣機', 3000, '7公斤容量','0', 4.8, '2023-07-03'),
('S000000002', 'C000000011', '電風扇', 500, '靜音運轉','0', 4.3, '2023-07-04'),
('S000000002', 'C000000011', '電鍋', 900, '多功能設計','0', 4.7, '2023-07-05'),
('S000000002', 'C000000011', '吹風機', 250, '快速乾髮','0', 4.6, '2023-07-06'),
('S000000002', 'C000000019', '電鍋', 800, '兒童安全設計','0', 4.4, '2023-07-07'),
('S000000002', 'C000000011', '電磁爐', 700, '省電節能','0', 4.2, '2023-07-08'),
('S000000002', 'C000000018', '咖啡機', 1200, '自動磨豆', '0',4.7, '2023-07-09'),
('S000000002', 'C000000011', '電鍋', 600, '保溫功能','0', 4.5, '2023-07-10'),
('S000000002', 'C000000012', 'LG雙門冰箱', 13900, '家用冰箱','0', 4.4, '2023-07-01'),
('S000000002', 'C000000012', 'Toshiba三門冰箱', 15900, '大容量冰箱','0', 4.1, '2023-07-02'),
('S000000002', 'C000000013', 'Samsung洗衣機', 17900, '前置式洗衣機','0', 4.8, '2023-07-03'),
('S000000002', 'C000000013', 'Panasonic乾衣機', 12900, '熱泵乾衣機','0', 4.3, '2023-07-04'),
('S000000002', 'C000000014', 'Sharp電視', 18900, '4K液晶電視','0', 4.6, '2023-07-05');


-- 美妝個清
INSERT INTO Product (registerSupplier, categorieId, productName, productPrice, productInfo,productStatus, avgRating, firstOnShelvesDate)
VALUES
('S000000003', 'C000000023', '粉底液', 300, '自然遮瑕','0', 4.5, '2023-07-01'),
('S000000003', 'C000000023', '口紅', 200, '豐唇顯色','0', 4.2, '2023-07-02'),
('S000000003', 'C000000023', '睫毛膏', 150, '加長濃密','0', 4.8, '2023-07-03'),
('S000000003', 'C000000023', '眼線筆', 100, '防水持久','0', 4.3, '2023-07-04'),
('S000000003', 'C000000023', '修容盤', 250, '打造立體臉','0', 4.7, '2023-07-05'),
('S000000003', 'C000000023', '化妝刷', 150, '柔軟觸感','0', 4.6, '2023-07-06'),
('S000000003', 'C000000023', '唇蜜', 180, '水潤光澤','0', 4.4, '2023-07-07'),
('S000000003', 'C000000023', '蜜粉', 200, '定妝服貼','0', 4.2, '2023-07-08'),
('S000000003', 'C000000023', '腮紅', 150, '自然飽和','0', 4.7, '2023-07-09'),
('S000000003', 'C000000023', '眉筆', 120, '填補空缺','0', 4.5, '2023-07-10'),
('S000000003', 'C000000022', 'SK-II精華露', 3690, '護膚精華', '0',4.9, '2023-07-01'),
('S000000003', 'C000000023', 'MAC口紅', 990, '時尚彩妝','0', 4.2, '2023-07-02'),
('S000000003', 'C000000023', 'Estee Lauder粉底液', 2890, '底妝必備','0', 4.6, '2023-07-03'),
('S000000003', 'C000000022', 'Shiseido眼霜', 2490, '眼部保養', '0',4.3, '2023-07-04'),
('S000000003', 'C000000025', 'Chanel香水', 3990, '經典香氛','0', 4.7, '2023-07-05');


-- 流行服飾
INSERT INTO Product (registerSupplier, categorieId, productName, productPrice, productInfo,productStatus, avgRating, firstOnShelvesDate)
VALUES
('S000000010', 'C000000032', 'T恤', 300, '舒適透氣','0', 4.5, '2023-07-01'),
('S000000010', 'C000000032', '襯衫', 400, '休閒正裝', '0',4.2, '2023-07-02'),
('S000000010', 'C000000035', '牛仔褲', 500, '修身顯瘦','0', 4.8, '2023-07-03'),
('S000000010', 'C000000035', '裙子', 350, '優雅女人味','0', 4.3, '2023-07-04'),
('S000000010', 'C000000036', '外套', 800, '保暖時尚','0', 4.7, '2023-07-05'),
('S000000010', 'C000000034', '運動褲', 250, '彈性自如','0', 4.6, '2023-07-06'),
('S000000010', 'C000000032', '連帽衫', 450, '潮流帥氣','0', 4.4, '2023-07-07'),
('S000000010', 'C000000032', '洋裝', 600, '氣質優雅','0', 4.2, '2023-07-08'),
('S000000010', 'C000000032', '背心', 200, '清涼透氣', '0',4.7, '2023-07-09'),
('S000000010', 'C000000036', '西裝', 1500, '商務正裝','0', 4.5, '2023-07-10'),
('S000000010', 'C000000032', '男士白襯衫', 790, '簡約百搭款', '0',4.5, '2023-07-01'),
('S000000010', 'C000000033', '女士連身裙', 1290, '時尚洋裝','0', 4.2, '2023-07-02'),
('S000000010', 'C000000034', '男士牛仔褲', 990, '休閒牛仔褲','0', 4.6, '2023-07-03'),
('S000000010', 'C000000035', '女士短裙', 690, '夏日必備','0', 4.3, '2023-07-04'),
('S000000010', 'C000000032', '男士T恤', 390, '舒適休閒款', '0',4.7, '2023-07-05');

-- 鞋包配飾
INSERT INTO Product (registerSupplier, categorieId, productName, productPrice, productInfo,productStatus, avgRating, firstOnShelvesDate)
VALUES
('S000000005', 'C000000042', '皮包', 800, '時尚大容量', '0',4.5, '2023-07-01'),
('S000000005', 'C000000043', '背包', 500, '輕便耐用','0',4.2, '2023-07-02'),
('S000000005', 'C000000042', '錢包', 300, '多卡位設計','0', 4.8, '2023-07-03'),
('S000000005', 'C000000041', '手錶', 1200, '精確時鐘','0', 4.3, '2023-07-04'),
('S000000005', 'C000000050', '太陽眼鏡', 250, '防UV鏡片','0', 4.7, '2023-07-05'),
('S000000005', 'C000000049', '帽子', 150, '遮陽防曬','0', 4.6, '2023-07-06'),
('S000000005', 'C000000047', '皮帶', 200, '時尚百搭','0', 4.4, '2023-07-07'),
('S000000005', 'C000000046', '項鍊', 180, '精緻飾品','0', 4.2, '2023-07-08'),
('S000000005', 'C000000046', '手環', 150, '個性潮流','0', 4.7, '2023-07-09'),
('S000000005', 'C000000046', '耳環', 120, '時尚耀眼','0', 4.5, '2023-07-10');

-- 母嬰用品
INSERT INTO Product (registerSupplier, categorieId, productName, productPrice, productInfo,productStatus, avgRating, firstOnShelvesDate)
VALUES
('S000000007', 'C000000054', '嬰兒推車', 1500, '輕巧易摺疊', '0',4.5, '2023-07-01'),
('S000000007', 'C000000055', '嬰兒床', 800, '安全舒適','0', 4.2, '2023-07-02'),
('S000000007', 'C000000053', '奶瓶', 200, '防脹氣設計','0', 4.8, '2023-07-03'),
('S000000007', 'C000000052', '尿布', 100, '柔軟透氣','0', 4.3, '2023-07-04'),
('S000000007', 'C000000056', '嬰兒衣服', 250, '純棉柔軟','0', 4.7, '2023-07-05'),
('S000000007', 'C000000056', '嬰兒鞋襪', 150, '舒適保暖', '0',4.6, '2023-07-06'),
('S000000007', 'C000000051', '嬰兒浴盆', 400, '可折疊設計','0', 4.4, '2023-07-07'),
('S000000007', 'C000000051', '安全座椅', 1200, '符合安全標準','0', 4.2, '2023-07-08'),
('S000000007', 'C000000059', '嬰兒玩具', 150, '多功能發展', '0',4.7, '2023-07-09'),
('S000000007', 'C000000051', '嬰兒護理套組', 120, '實用完整','0', 4.5, '2023-07-10');

-- 日用生活
INSERT INTO Product (registerSupplier, categorieId, productName, productPrice, productInfo,productStatus, avgRating, firstOnShelvesDate)
VALUES
('S000000006', 'C000000062', '剪刀', 50, '鋒利耐用', '0',4.5, '2023-07-01'),
('S000000006', 'C000000062', '鍋子', 300, '不沾鍋','0', 4.2, '2023-07-02'),
('S000000006', 'C000000062', '杯子', 100, '保溫保冷','0', 4.8, '2023-07-03'),
('S000000006', 'C000000062', '碗盤', 80, '耐摔不易破','0', 4.3, '2023-07-04'),
('S000000006', 'C000000068', '收納盒', 200, '多格分類','0', 4.7, '2023-07-05'),
('S000000006', 'C000000066', '浴巾', 150, '柔軟吸水', '0',4.6, '2023-07-06'),
('S000000006', 'C000000064', '掃把', 80, '好握不掉毛','0', 4.4, '2023-07-07'),
('S000000006', 'C000000064', '拖把', 100, '乾濕兩用','0', 4.2, '2023-07-08'),
('S000000006', 'C000000064', '洗衣粉', 120, '去污力強','0', 4.7, '2023-07-09'),
('S000000006', 'C000000064', '垃圾袋', 50, '抗拉不易破','0', 4.5, '2023-07-10');

-- 圖書文具
INSERT INTO Product (registerSupplier, categorieId, productName, productPrice, productInfo,productStatus, avgRating, firstOnShelvesDate)
VALUES
('S000000008', 'C000000073', '筆記本', 80, '柔軟筆觸','0', 4.5, '2023-07-01'),
('S000000008', 'C000000074', '鉛筆', 30, 'HB硬度','0', 4.2, '2023-07-02'),
('S000000008', 'C000000077', '彩色筆', 50, '明亮色彩','0', 4.8, '2023-07-03'),
('S000000008', 'C000000074', '修正帶', 20, '方便使用','0', 4.3, '2023-07-04'),
('S000000008', 'C000000075', '文件夾', 40, '夾緊文件','0', 4.7, '2023-07-05'),
('S000000008', 'C000000075', '文件袋', 30, '透明耐用','0', 4.6, '2023-07-06'),
('S000000008', 'C000000073', '便條紙', 25, '易撕易貼','0', 4.4, '2023-07-07'),
('S000000008', 'C000000075', '筆袋', 50, '收納筆具','0', 4.2, '2023-07-08'),
('S000000008', 'C000000074', '橡皮擦', 10, '不易殘留','0', 4.7, '2023-07-09'),
('S000000008', 'C000000074', '尺', 15, '精確測量','0', 4.5, '2023-07-10'),
('S000000009', 'C000000072', '小王子', 290, '經典童書', '0',4.4, '2023-07-01'),
('S000000009', 'C000000072', '哈利波特', 390, '魔法冒險小說','0', 4.1, '2023-07-02'),
('S000000009', 'C000000072', '大全圖解英語', 390, '初學者英語書','0', 4.6, '2023-07-03'),
('S000000009', 'C000000072', '世界地圖', 190, '精美地圖書','0', 4.3, '2023-07-04'),
('S000000009', 'C000000072', '數學入門', 290, '基礎數學概念','0', 4.7, '2023-07-05');

-- 旅遊戶外
INSERT INTO Product (registerSupplier, categorieId, productName, productPrice, productInfo,productStatus, avgRating, firstOnShelvesDate)
VALUES
('S000000004', 'C000000084', '帳篷', 800, '防水透氣','0', 4.5, '2023-07-01'),
('S000000004', 'C000000085', '睡袋', 500, '保暖輕便','0', 4.2, '2023-07-02'),
('S000000004', 'C000000086', '登山鞋', 1200, '耐磨防滑','0', 4.8, '2023-07-03'),
('S000000004', 'C000000087', '釣魚竿', 600, '輕巧方便','0', 4.3, '2023-07-04'),
('S000000004', 'C000000086', '背包', 300, '防水耐用','0', 4.7, '2023-07-05'),
('S000000004', 'C000000086', '登山杖', 200, '伸縮調節','0', 4.6, '2023-07-06'),
('S000000004', 'C000000086', '營養食品', 150, '輕便營養','0', 4.4, '2023-07-07'),
('S000000004', 'C000000089', '手電筒', 100, '長效亮度','0', 4.2, '2023-07-08'),
('S000000004', 'C000000089', '水壺', 50, '耐用無漏','0', 4.7, '2023-07-09'),
('S000000004', 'C000000089', '望遠鏡', 1500, '高清視野','0', 4.5, '2023-07-10');


-- 商品規格
CREATE TABLE ProductSpec (
  productSpecId CHAR(11) comment '商品規格編號(主鍵)' PRIMARY KEY,
  productId INT not null comment '商品編號(外來鍵)',
  specType1 ENUM('1' ,'2' ,'3','4') comment '規格類型1：1 尺寸, 2 顏色 , 3 容量 , 4 材質',
  specInfo1 VARCHAR(10) comment '規格1詳細',
  specType2 ENUM('1' ,'2' ,'3','4') comment '規格類型2： 1 尺寸, 2 顏色 , 3 容量 , 4 材質', 
  specInfo2 VARCHAR(10) comment '規格2詳細',
  specPicture LONGBLOB comment '規格圖',
  shelvesStatus ENUM('0','1','2') default('0') comment '上架狀態：0 上架 , 1 下架 , 2 永久下架',
  initialStock INT unsigned not null comment '首次備貨量',
  specStock INT unsigned not null comment '庫存',
  constraint FK_Product_specProductId foreign key (productId) references Product (productId)
)comment '商品規格';

-- 3C周邊
INSERT INTO ProductSpec (productSpecId, productId, specType1, specInfo1, specType2,specInfo2, shelvesStatus, initialStock,specStock)
VALUES
('10000001001',10000001,'3','256GB','4','鈦合金','0',100,100),							
('10000002001',10000002,'2','黑色','1','XL','0',100,100),							
('10000003001',10000003,'2','米白色','1','XXL','0',100,100),							
('10000004001',10000004,'3','1TB','2','白色','0',100,100),							
('10000005001',10000005,'4','銅','1','159cm','0',100,100),							
('10000006001',10000006,'1','12吋','2','玫瑰紅','0',100,100),							
('10000007001',10000007,'1','15吋','2','玫瑰金','0',100,100),							
('10000008001',10000008,'3','無限上網','4','塑膠','0',100,100),							
('10000009001',10000009,'1','8吋','2','灰色','0',100,100),							
('10000010001',10000010,'3','1TB','4','鈦合金','0',100,100),							
('10000011001',10000011,'1','15吋','2','天空藍','0',100,100),							
('10000012001',10000012,'3','256GB','2','紫金色','0',100,100),							
('10000013001',10000013,'1','12吋','2','天空灰','0',100,100),							
('10000014001',10000014,'1','10吋','2','天空白','0',100,100),							
('10000015001',10000015,'3','1TB','1','12吋','0',100,100);								


-- 家用電器
INSERT INTO ProductSpec (productSpecId, productId, specType1, specInfo1, specType2,specInfo2, shelvesStatus, initialStock,specStock)
VALUES
('10000016001',10000016,'2','米白色','3','XL','0',100,100),
('10000017001',10000017,'3','1.5匹','4','塑膠','0',100,100),
('10000018001',10000018,'2','黑金色','3','3L','0',100,100),
('10000019001',10000019,'2','米白色','3','XL','0',100,100),
('10000020001',10000020,'2','紅色','3','4L','0',100,100),
('10000021001',10000021,'2','玫瑰金','3','L','0',100,100),
('10000022001',10000022,'2','綠色','3','2L','0',100,100),
('10000023001',10000023,'2','黑金色','3','L','0',100,100),
('10000024001',10000024,'2','白色','3','2L','0',100,100),
('10000025001',10000025,'2','米白色','3','3L','0',100,100),
('10000026001',10000026,'2','紫金色','3','580公升','0',100,100),
('10000027001',10000027,'2','天空星','3','600公升','0',100,100),
('10000028001',10000028,'2','白色','3','5L','0',100,100),
('10000029001',10000029,'2','灰色','3','3L','0',100,100),
('10000030001',10000030,'1','15吋','4','塑膠','0',100,100);


-- 美妝個清
INSERT INTO ProductSpec (productSpecId, productId, specType1, specInfo1, specType2,specInfo2, shelvesStatus, initialStock,specStock)
VALUES
('10000031001',10000031,'3','15ml','2','膚色','0',100,100),
('10000032001',10000032,'2','紅色','3','10ml','0',100,100),
('10000033001',10000033,'1','15cm','2','黑色','0',100,100),
('10000034001',10000034,'2','黑色','4','木質','0',100,100),
('10000035001',10000035,'4','塑膠','1','5吋','0',100,100),
('10000036001',10000036,'3','L','4','塑膠','0',100,100),
('10000037001',10000037,'2','粉金色','3','10ml','0',100,100),
('10000038001',10000038,'2','粉金色','3','10ml','0',100,100),
('10000039001',10000039,'2','灰色','1','15cm','0',100,100),
('10000040001',10000040,'1','15cm','2','黑色','0',100,100),
('10000041001',10000041,'3','10ml','4','珍珠','0',100,100),
('10000042001',10000042,'2','紅色','3','10ml','0',100,100),
('10000043001',10000043,'3','50ml','2','膚色','0',100,100),
('10000044001',10000044,'3','50ml','4','珍珠','0',100,100),
('10000045001',10000045,'2','紫色','3','250ml','0',100,100);


-- 流行服飾
INSERT INTO ProductSpec (productSpecId, productId, specType1, specInfo1, specType2,specInfo2, shelvesStatus, initialStock,specStock)
VALUES
('10000046001',10000046,'2','白色','4','棉製','0',100,100),
('10000047001',10000047,'2','粉色','4','不織布','0',100,100),
('10000048001',10000048,'2','藍色','4','不織布','0',100,100),
('10000049001',10000049,'2','灰色','4','棉製','0',100,100),
('10000050001',10000050,'2','綠色','4','合成衣','0',100,100),
('10000051001',10000051,'2','黑色','4','棉製','0',100,100),
('10000052001',10000052,'2','黃色','4','合成衣','0',100,100),
('10000053001',10000053,'2','黃色','4','合成毛','0',100,100),
('10000054001',10000054,'1','S','2','黑色','0',100,100),
('10000055001',10000055,'1','M','2','黑色','0',100,100),
('10000056001',10000056,'1','ML','2','白色','0',100,100),
('10000057001',10000057,'1','XML','2','膚色','0',100,100),
('10000058001',10000058,'1','XXL','2','天空藍','0',100,100),
('10000059001',10000059,'1','S','2','灰色','0',100,100),
('10000060001',10000060,'1','M','2','白色','0',100,100);



-- 鞋包配飾
INSERT INTO ProductSpec (productSpecId, productId, specType1, specInfo1, specType2,specInfo2, shelvesStatus, initialStock,specStock)
VALUES
('10000061001',10000061,'4','皮製','2','黑色','0',100,100),
('10000062001',10000062,'4','牛仔','2','白色','0',100,100),
('10000063001',10000063,'4','布製','2','藍色','0',100,100),
('10000064001',10000064,'4','合金','2','黃色','0',100,100),
('10000065001',10000065,'4','強化塑膠','2','黑色','0',100,100),
('10000066001',10000066,'4','棉制','2','綠色','0',100,100),
('10000067001',10000067,'4','皮製','2','咖啡色','0',100,100),
('10000068001',10000068,'4','合成銀','2','粉金色','0',100,100),
('10000069001',10000069,'4','合成金','2','粉金色','0',100,100),
('10000070001',10000070,'4','合成金','2','粉金色','0',100,100);



-- 母嬰用品
INSERT INTO ProductSpec (productSpecId, productId, specType1, specInfo1, specType2,specInfo2, shelvesStatus, initialStock,specStock)
VALUES
('10000071001',10000071,'4','木製','3','XL','0',100,100),
('10000072001',10000072,'4','木製','1','12m','0',100,100),
('10000073001',10000073,'4','玻璃','3','250ml','0',100,100),
('10000074001',10000074,'4','不織布','3','5kg','0',100,100),
('10000075001',10000075,'4','棉製','1','S','0',100,100),
('10000076001',10000076,'4','棉製','1','S','0',100,100),
('10000077001',10000077,'4','塑膠','3','1公升','0',100,100),
('10000078001',10000078,'4','塑膠','1','12m','0',100,100),
('10000079001',10000079,'4','塑膠','2','紅色','0',100,100),
('10000080001',10000080,'4','綿羊油','3','250ml','0',100,100);


-- 日用生活
INSERT INTO ProductSpec (productSpecId, productId, specType1, specInfo1, specType2,specInfo2, shelvesStatus, initialStock,specStock)
VALUES
('10000081001',10000081,'4','銅製','2','粉紅色','0',100,100),
('10000082001',10000082,'4','不銹鋼','2','黃色','0',100,100),
('10000083001',10000083,'4','玻璃','2','紅色','0',100,100),
('10000084001',10000084,'4','磁器','2','透明','0',100,100),
('10000085001',10000085,'4','塑膠','2','綠色','0',100,100),
('10000086001',10000086,'4','棉製','2','天空藍','0',100,100),
('10000087001',10000087,'4','塑膠','1','12m','0',100,100),
('10000088001',10000088,'4','塑膠','1','12m','0',100,100),
('10000089001',10000089,'1','2m','3','3L','0',100,100),
('10000090001',10000090,'4','塑膠','3','3L','0',100,100);


-- 圖書文具
INSERT INTO ProductSpec (productSpecId, productId, specType1, specInfo1, specType2,specInfo2, shelvesStatus, initialStock,specStock)
VALUES
('10000091001',10000091,'1','XL','2','咖啡色','0',100,100),
('10000092001',10000092,'1','10cm','4','木製','0',100,100),
('10000093001',10000093,'1','10cm','4','木製','0',100,100),
('10000094001',10000094,'1','10cm','2','粉色','0',100,100),
('10000095001',10000095,'1','30cm','2','青灰色','0',100,100),
('10000096001',10000096,'1','30cm','2','青灰色','0',100,100),
('10000097001',10000097,'1','15cm','2','青色','0',100,100),
('10000098001',10000098,'4','布製','2','白色','0',100,100),
('10000099001',10000099,'1','5cm','2','灰色','0',100,100),
('10000100001',10000100,'1','30cm','4','塑膠','0',100,100),
('10000101001',10000101,'4','精裝','3','32頁','0',100,100),
('10000102001',10000102,'4','平裝','3','500頁','0',100,100),
('10000103001',10000103,'4','精裝','3','1000頁','0',100,100),
('10000104001',10000104,'4','平裝','3','10頁','0',100,100),
('10000105001',10000105,'4','平裝','3','32頁','0',100,100);



-- 旅遊戶外
INSERT INTO ProductSpec (productSpecId, productId, specType1, specInfo1, specType2,specInfo2, shelvesStatus, initialStock,specStock)
VALUES
('10000106001',10000106,'2','綠色','4','不織布','0',100,100),
('10000107001',10000107,'2','白色','4','不織布','0',100,100),
('10000108001',10000108,'2','紅色','4','橡膠','0',100,100),
('10000109001',10000109,'1','12m','4','塑膠','0',100,100),
('10000110001',10000110,'2','綠色','4','不織布','0',100,100),
('10000111001',10000111,'1','12m','4','橡膠','0',100,100),
('10000112001',10000112,'3','3L','4','米製','0',100,100),
('10000113001',10000113,'2','黑色','4','銅製','0',100,100),
('10000114001',10000114,'2','黑色','4','塑膠','0',100,100),
('10000115001',10000115,'2','黑色','4','鈦合金','0',100,100);

-- 商品補貨紀錄
CREATE TABLE RestockRecord (
  restockId CHAR(14) comment '補貨單號(主鍵)' PRIMARY KEY,
  productId INT not null comment '商品編號(外來鍵)',
  productSpecId CHAR(11) not null comment '商品規格編號(外來鍵)',
  restockMemberId CHAR(10) not null comment '變更人(會員編號)(外來鍵)',
  beforeRestockStock INT unsigned not null comment '補貨前庫存',
  restockQuantity INT unsigned not null comment '補貨數量',
  afterRestockStock INT unsigned not null comment '補貨後庫存',
  restockDate DATE default(NOW()) comment '補貨日期',
  constraint FK_RestockRecord_productId foreign key (productId) references Product (productId),
  constraint FK_RestockRecord_productSpecId foreign key (productSpecId) references ProductSpec (productSpecId),
  constraint FK_RestockRecord_restockMemberId foreign key (restockMemberId) references Member (memberId)
) comment '商品補貨紀錄';

-- 商品上下架紀錄
CREATE TABLE ShelvesStatusRecord (
  shelvesStatusId CHAR(14) comment '上/下架編號(主鍵)' PRIMARY KEY,
  productId INT not null comment '商品編號(外來鍵)',
  productSpecId CHAR(11) not null comment '商品規格編號(外來鍵)',
  shelvesMemberId  CHAR(10) not null comment '變更人(會員編號)(外來鍵)',
  statusModify ENUM("0","1") not null comment ' 變更類型：0上架 、1下架',
  statusModifyTime TIMESTAMP default(NOW()) comment '變更日期',
  constraint FK_Shelves_statusRecordProductId foreign key (productId) references Product (productId),
  constraint FK_Shelves_statusRecordProductSpecId foreign key (productSpecId) references ProductSpec (productSpecId),
  constraint FK_Shelves_statusRecordShelvesMemberId foreign key (shelvesMemberId) references `Member` (memberId)
) comment '商品上下架紀錄';

-- 行銷活動(單一門檻)
CREATE TABLE EventSingleThreshold(
  eventId CHAR(16) primary key comment '行銷活動編號',
  eventRegisterSupplier CHAR(10) comment '活動所屬商家 ; null 代表是平台的活動', 
  eventType ENUM('1','2','3','4') not null comment '活動類型：1 商品折價券, 2 全站折價券, 3 商品折扣活動 , 4 商品贈品活動' ,
  eventName VARCHAR(20) not null comment '活動名稱',
  eventInfo VARCHAR(40) not null comment '活動說明' ,
  eventStart DATE DEFAULT(NOW()) comment '活動起始日' ,
  eventEnd DATE not null comment '活動結束日' ,
  thresholdType ENUM('1','2','3') not null comment '門檻類型 ; 1 滿額, 2滿件, 3 滿件且滿額' ,
  minPurchaseQuantity INT unsigned comment '滿件門檻',
  minPurchaseAmount INT unsigned comment '滿額門檻',
  discountRate DECIMAL(3,2) comment '折扣比例',
  discountAmount INT unsigned comment '折扣定額',
  giftProductId INT comment '贈品商品編號', 
  couponCode CHAR(10) unique comment '折價券歸戶代碼',
  couponAvailableAmount INT unsigned comment '折價券使用張數上限',
  couponUsedAmount INT unsigned comment '折價券已使用張數',
  couponAvailablePerPurchase INT unsigned comment '單筆可使用折價券張數',
  constraint FK_EventSingleThreshold_eventRegisterSupplier foreign key (eventRegisterSupplier) references Supplier (supplierId),
  constraint FK_Event_SingleThreshold_giftProductId foreign key (giftProductId) references Product (productId)
) comment '行銷活動(單一門檻)';

-- 行銷活動適用商品
create table EventApplicableProducts(
  eventId  CHAR(16),
  productId INT,
  constraint `PK_EventApplicableProducts_eventId&productId` PRIMARY KEY (eventId,productId),
  constraint FK_EventApplicableProducts_eventId foreign key (eventId) references EventSingleThreshold (eventId),
  constraint FK_EventApplicableProducts_productId foreign key (productId) references Product (productId)
) comment '行銷活動適用商品';

-- 會員折價券清單
create table MemberCouponList(
  memberId  CHAR(10) comment'會員編號',
  couponCode VARCHAR(10) comment'折價券歸戶代碼',
  couponStatus ENUM('0','1','2') default('0') comment'折價券狀態:0未使用,1已使用,2已過期',
  PRIMARY KEY (memberId , couponCode),
  constraint FK_MemberCouponList_memberId foreign key (memberId) references `Member`(memberId)
) comment '會員折價券清單';

-- 主訂單
CREATE TABLE `MainOrder` (
  `orderId` char(17) NOT NULL comment '訂單編號' ,
  `memberId` char(10) DEFAULT NULL comment '會員編號' ,
  `orderCreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP comment '立單時間',
  `orderStatus` enum('0','1') DEFAULT '0' comment '訂單狀態： 0 成立, 1 不成立',
  `totalAmount` int unsigned DEFAULT NULL comment '總訂購金額',
  `totalGrossProfit` int unsigned DEFAULT NULL comment '總毛利',
  `pointsDiscount` int unsigned DEFAULT '0' comment '會員點數折抵金額',
  `couponDiscount` int unsigned DEFAULT '0' comment '全站折價券折抵金額',
  `paidAmount` int unsigned DEFAULT NULL comment '最終結帳金額',
  `paymentType` enum('1','2') DEFAULT NULL comment '付款方式：1信用卡, 2第三方支付',
  `paymentStatus` enum('0','1','2') DEFAULT NULL comment '付款狀態：0待付款, 1付款成功, 2付款失敗',
  `paymentTime` timestamp NULL DEFAULT NULL comment '付款時間',
  `billStatus` enum('0','1','2','3') DEFAULT NULL comment '請款狀態：0待請款, 1請款成功, 2請款失敗',
  `billDate` date DEFAULT NULL comment '預計請款日期',
  `shipmentType` varchar(15) DEFAULT '宅配' comment '物流方式',
  `recipient` varchar(10) DEFAULT NULL comment '收件人',
  `phoneNum` char(12) DEFAULT NULL comment '收件人電話',
  `deliveryAddress` varchar(100) DEFAULT NULL comment '配送地址',
  PRIMARY KEY (`orderId`),
  CONSTRAINT FK_MainOrder_memberId foreign key (memberId) references `Member` (memberId)
) comment '主訂單';

-- 子訂單
CREATE TABLE `SubOrder` (
  `subOrderId` CHAR(21) comment '子訂單編號',
  `orderId` CHAR(17) not null comment '訂單編號',
  `supplierId` CHAR(10) not null comment '商家編號',
  `memberId` CHAR(10) not null comment '會員編號',
  `orderCreateTime` TIMESTAMP not null comment '訂單成立時間',
  `orderCloseTime` TIMESTAMP comment '訂單結案時間',
  `subOrderStatus` ENUM('0', '1', '2','3','4','5')default('0') not null comment '子訂單狀態： 0 待處理, 1 配送中 ,2 已送達, 3 已完成, 4 已退貨/退款, 5 已取消' , 
  `subPaidAmount` INT unsigned not null comment '子訂單結帳金額',
  `subPointsDiscount` INT unsigned default(0) not null comment '子訂單會員點數折抵金額(按比例)',
  `subCouponDiscount` INT unsigned default(0) not null comment '子訂單全站折價券折抵金額(按比例)',
  `grossProfit` INT unsigned not null comment '毛利',
  `pointsReward` INT unsigned not null comment '點數回饋',
  `grantStatus` ENUM('0', '1', '2' , '3') default('0') not null comment '撥款狀態：0 待撥款, 1 撥款成功 ,2  撥款失敗 , 3 取消撥款',
  `grantDate` TIMESTAMP comment '預計撥款日期',
  `recipient` VARCHAR(10) not null comment '收件人',
  `phoneNum` CHAR(12) not null comment '收件人電話',
  `deliveryAddress` VARCHAR(100) not null comment '配送地址',
  PRIMARY KEY (`suborderid`),
  CONSTRAINT FK_SubOrder_orderId foreign key (orderId) references MainOrder (orderId),
  CONSTRAINT FK_SubOrder_supplierId foreign key (supplierId) references Supplier (supplierId),
  CONSTRAINT FK_SubOrder_memberId foreign key (memberId) references `Member` (memberId)
);

-- 子訂單明細
CREATE TABLE `SubOrderDetail` (
  `orderDetailId` CHAR(25) comment '訂單明細編號' PRIMARY KEY ,
  `subOrderId` CHAR(21) NOT NULL comment '子訂單編號' ,
  `orderId` CHAR(17) NOT NULL comment '訂單編號' ,
  `productId` INT NOT NULL comment '商品編號' ,
  `productSpecId` CHAR(11) NOT NULL comment '規格編號' ,
  `productPrice` INT UNSIGNED NOT NULL comment '商品售價' ,
  `itemCouponDiscount` INT UNSIGNED DEFAULT 0 NOT NULL comment '商品折價券折抵金額' ,
  `eventPrice` INT UNSIGNED NOT NULL comment '活動價' ,
  `ratingStar` INT UNSIGNED comment '商品評價(星星)' ,
  `comment` VARCHAR(150) comment '商品評價' ,
  `commentDate` DATE comment '評論日期' ,
  `refundDeadline` DATE comment '退貨期限' ,
  `refundReason` ENUM('0','1','2','3') comment '退貨原因' ,
  `refundRemark` VARCHAR(150) comment '備註' ,
  `itemStatus` ENUM ('0','1','2') default('0') comment '商品狀態:0 正常 , 1 取消 , 2 退貨' ,
  CONSTRAINT FK_SubOrderDetail_subOrderId FOREIGN KEY (subOrderId) REFERENCES `SubOrder` (subOrderId),
  CONSTRAINT FK_SubOrderDetail_orderId FOREIGN KEY (orderId) REFERENCES `MainOrder` (orderId),
  CONSTRAINT FK_SubOrderDetail_productId FOREIGN KEY (productId) REFERENCES Product (productId),
  CONSTRAINT FK_SubOrderDetail_productSpecId FOREIGN KEY (productSpecId) REFERENCES `ProductSpec` (productSpecId)
);

-- 會員點數紀錄
CREATE TABLE MemberPointsRecord (
  pointRecordId INT auto_increment not null PRIMARY KEY comment'點數紀錄編號',
  memberId  CHAR(10) not null comment'會員編號',
  pointStatusModify ENUM('1','2','3','4') not null comment'狀態變更類型：1訂單回饋,2訂單折抵,3人工補點,4人工扣點',
  pointAdjustTime TIMESTAMP default(NOW()) comment'變更時間',
  subOrderId CHAR(21) comment'子訂單編號',
  PointExp Date comment'點數有效期限',
  dealerUserId int comment'使用者編號',
  ReasonForChangePt ENUM('1','2') comment'人工變更原因:1訂單異常,2系統異常',
  pointReduced INT unsigned comment'減少數量',
  pointIncreased INT unsigned comment'增加數量',
  constraint FK_MemberPointsRecord_memberId foreign key (memberId) references `Member`(memberId),
  constraint FK_MemberPointsRecord_dealerUserId foreign key (dealerUserId) references `User`(userId)
)auto_increment=1000000001 comment '會員點數紀錄';

-- 廣告版位
CREATE TABLE `AdSpace` (
  `adSpaceId` CHAR(15) comment '版位編號' PRIMARY KEY,
  `adSpaceName` CHAR(10) NOT NULL comment '版位名稱',
  `adPageId` CHAR(10) NOT NULL comment '所屬頁面',
  CONSTRAINT FK_AdSpace_adPageId FOREIGN KEY (`adPageId`) REFERENCES `FrontendPage` (`pageId`)
);

-- 廣告
CREATE TABLE `Advertise` (
  `advertiseId` CHAR(17) comment '廣告編號' PRIMARY KEY,
  `adSupplierId` CHAR(10) comment '承租人(商家編號)',
  `adSpaceId` CHAR(15) NOT NULL comment '版位編號',
  `productId` CHAR(8) comment '商品編號',
  `pageId` CHAR(10) comment '頁面編號',
  `adStart` DATE comment '廣告起始日',
  `adEnd` DATE comment '廣告結束日',
  `cost` INT UNSIGNED comment '廣告費用',
  `adReviewStatus` ENUM('0','1') comment '審核狀態',
  `debitDate` DATE comment '預計扣款時間',
  `debitStatus` ENUM('0', '1', '2', '3') DEFAULT '0' comment '扣款狀態',
  `adRemark` VARCHAR(150) NOT NULL comment '廣告說明',
  `adPicture` LONGBLOB comment '廣告圖片',
  CONSTRAINT FK_Advertise_adSupplierId FOREIGN KEY (`adSupplierId`) REFERENCES `Supplier` (`supplierId`),
  CONSTRAINT FK_Advertise_adSpaceId FOREIGN KEY (`adSpaceId`) REFERENCES `AdSpace` (`adSpaceId`),
  CONSTRAINT FK_Advertise_pageId FOREIGN KEY (`pageId`) REFERENCES `FrontendPage` (`pageId`)
);

-- 排序權重
CREATE TABLE SortWeight (
  weightsUpdateTime TIMESTAMP default(NOW()) comment '更新時間(主鍵)' PRIMARY KEY,
  dealerUserId INT comment '經手人(使用者編號)(外來鍵)',
  dataPeriod ENUM('0', '7', '30','90' ,'365') not null comment '資料計算期間：0 當日, 7 當週, 30 當月, 90 當季, 365 當年', 
  weights1 ENUM('1', '2', '3','4','5','6') not null comment '權重一：1 點擊量, 2 商品評價, 3 銷售量, 4 銷售額, 5 成交率, 6 上市時間', 
  weights1Ratio DECIMAL(3,2) default 0.30 comment '權重一比重',
  weights2 ENUM('1', '2', '3','4','5','6') not null comment '權重二：1 點擊量, 2 商品評價, 3 銷售量, 4 銷售額, 5 成交率, 6 上市時間',
  weights2Ratio DECIMAL(3,2) default 0.20 comment '權重二比重',
  weights3 ENUM('1', '2', '3','4','5','6') not null comment '權重三：1 點擊量, 2 商品評價, 3 銷售量, 4 銷售額, 5 成交率, 6 上市時間', 
  weights3Ratio DECIMAL(3,2) default 0.20 comment '權重三比重',
  weights4 ENUM('1', '2', '3','4','5','6') not null comment '權重四：1 點擊量, 2 商品評價, 3 銷售量, 4 銷售額, 5 成交率, 6 上市時間',
  weights4Ratio DECIMAL(3,2) default 0.15 comment '權重四比重',
  weights5 ENUM('1', '2', '3','4','5','6') not null comment '權重五：1 點擊量, 2 商品評價, 3 銷售量, 4 銷售額, 5 成交率, 6 上市時間', 
  weights5Ratio DECIMAL(3,2) default 0.10 comment '權重五比重',
  weights6 ENUM('1', '2', '3','4','5','6') not null comment '權重六：1 點擊量, 2 商品評價, 3 銷售量, 4 銷售額, 5 成交率, 6 上市時間',
  weights6ratio DECIMAL(3,2) default 0.05 comment '權重六比重',
  constraint FK_SortWeights_dealerUserId foreign key (dealerUserId) references User (userId)
) comment '排序權重';

INSERT INTO SortWeight(dealerUserId,dataPeriod,weights1,weights2,weights3,weights4,weights5,weights6)
VALUES(10001,'7','1','2','3','4','5','6');

-- 通知模板
CREATE TABLE `NotificationModel` (
  `notificationId` INT auto_increment comment '通知編號',
  `notificationType` VARCHAR(20) not null comment '通知類別',
  `notificationContent` VARCHAR(150) not null comment '通知內文',
  PRIMARY KEY (`notificationId`)
)auto_inCREMENT = 100 comment '通知模板';
