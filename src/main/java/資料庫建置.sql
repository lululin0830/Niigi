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
DROP TABLE IF EXISTS `Supplier`;
DROP TABLE IF EXISTS `User`;
DROP TABLE IF EXISTS `Member`;

-- 會員資料表
CREATE TABLE `Member` (
  memberId CHAR(10) comment'會員編號' primary key,
  memberAcct VARCHAR(50) not null comment'會員帳號' unique,
  `password` VARCHAR(600) not null comment'密碼',
  phone CHAR(12) not null comment'手機',
  `name` VARCHAR(20) not null comment'姓名',
  gender ENUM('0','1') not null comment'性別:0是男1是女',
  birthday DATE not null comment'生日',
  memPhoto LONGBLOB comment'會員圖片',
  memPointBalance INT default(0) comment'會員點數餘額',
  memPointMinExp date not null comment'會員點數最短有效期限',
  creditNum CHAR(16)  not null unique comment'信用卡卡號',
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
  
INSERT INTO `Member` (memberId, memberAcct, `password`, phone, `name`, gender, birthday, memPointBalance, memPointMinExp, creditNum, creditExp, cvv, cardholder, regTime, banStatus, backupEmail, memberAddress, lastRecipient, lastPhoneNum, lastDeliveryAddress, regStatusOpen, backupStatusOpen)
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
CREATE TABLE `User` (
  userId INT auto_increment comment'使用者編號' primary key,
  userName VARCHAR(15) not null comment'使用者名稱',
  userAcct VARCHAR(15) not null comment'使用者帳號',
  `password` VARCHAR(600) not null comment'密碼',
  financialAuthority ENUM('0','1') default('0') comment'財務權限',
  customerServiceAuthority ENUM('0','1') default('0') comment'客服權限',
  marketingAuthority ENUM('0','1') default('0') comment'行銷權限',
  hrAuthority ENUM('0','1')  default('0') comment'人事權限'
)auto_increment=10001 comment '平台使用者';

INSERT INTO `User` (userName, userAcct, `password`, financialAuthority, customerServiceAuthority, marketingAuthority, hrAuthority)
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
CREATE TABLE `Supplier` (
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


INSERT INTO `Supplier` (supplierId, supplierMemberAcct, businessId, ownerId, supplierAddress, bankCode, bankAcct, shopName, shopInfo, logo, shopBackground,approvalStatus, approvalRemark, enableTime)
VALUES
('S000000001', 'lululin0830@gmail.com', '12868358', 'A222212345', '104 台北市 中山區 南京東路三段219號5樓', '004', '142004254382', 'THE BEST', 'High Quality', NULL, NULL,'0', NULL, '2023-05-05 00:00:00'),
('S000000002', 'anthony963741@gmail.com', '24708053', 'A123456789', '104 台北市 中山區 南京東路三段219號5樓', '833', '87273837489506', '好好買', '應有盡有', NULL, NULL,'0', NULL, '2023-05-05 00:00:00'),
('S000000003', 'davida56254@gmail.com', NULL , 'U22386098', '709 臺南市安南區館安一路28號', '566', '39586094886748', '買多多', 'VERY GOOD', NULL, NULL,'0', NULL, '2023-06-05 00:00:00'),
('S000000004', 'jane@example.com', '02935677', 'D221184906', '974 花蓮縣壽豐鄉豐富街32號', '456', '34356654908', '露得輕', '露營用品專賣', NULL, NULL,'0', NULL, '2023-06-05 00:00:00'),
('S000000005', 'david@example.com', '67345723', 'Q124857667', '325 桃園市龍潭區向陽二街20號', '346', '726458699345', 'DREAMER', 'SLEEPING...', NULL, NULL,'0', NULL, '2023-06-05 00:00:00'),
('S000000006', 'jeff@example.com', '23454398', 'Y126654098', '905 屏東縣里港鄉茄苳路3號', '012', '37775883998760', 'WHY東西', 'BAD', NULL, NULL,'0', NULL, '2023-07-05 00:00:00'),
('S000000007', 'mary@example.com', '65748339', 'F220495193', '522 彰化縣田尾鄉新生路14號', '002', '395857764849', 'CHOO', '優質母嬰用品',  NULL, NULL,'0', NULL, '2023-07-05 00:00:00'),
('S000000008', 'sarah@example.com', '63544001', 'W123374960', '237 新北市三峽區學府路3號', '083', '377850069372', '今拾糖', '進口糖果餅乾',  NULL, NULL,'0', NULL, '2023-07-05 00:00:00'),
('S000000009', 'emily@example.com', NULL, 'S228576698', '335 桃園市大溪區打鐵寮路19號', '523', '3857768874532', 'LET ME IN', 'NOOOOO', NULL, NULL,'0', NULL, '2023-05-05 00:00:00'),
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
  dealerUserId int not null comment'C經手人(使用者編號)',
  suspendStart DATE default(NOW()) comment'停權開始時間',
  suspendEnd DATE not null comment'停權結束時間',
  suspendDuration ENUM('1','3','7','30') not null comment'停權天數:1永久停權,3是3天停權,7是7天停權,30是30天停權',
  suspendStatusChange ENUM('1','3','7','30') comment'停權天數:1永久停權,3是3天停權,7是7天停權,30是30天停權',
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
  categorieId CHAR(9) not null comment '商品分類編號' PRIMARY KEY,
  categorieName VARCHAR(10) not null comment '商品分類名稱',
  mainCategorie  CHAR(9) comment '所屬商品分類',
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
    ('C000000030', '口紅', 'C000000021'),
    -- 流行服飾
    ('C000000031', '流行服飾', NULL),
    ('C000000032', '男士上衣', 'C000000031'),
    ('C000000033', '女士上衣', 'C000000031'),
    ('C000000034', '男士褲子', 'C000000031'),
    ('C000000035', '女士褲子', 'C000000031'),
    ('C000000036', '男士外套', 'C000000031'),
    ('C000000037', '女士外套', 'C000000031'),
    ('C000000038', '男士鞋子', 'C000000031'),
    ('C000000039', '女士鞋子', 'C000000031'),
    ('C000000040', '帽子', 'C000000031'),
    -- 鞋包配飾
    ('C000000041', '鞋包配飾', NULL),
    ('C000000042', '女士手提包', 'C000000041'),
    ('C000000043', '男士背包', 'C000000041'),
    ('C000000044', '女士皮鞋', 'C000000041'),
    ('C000000045', '男士運動鞋', 'C000000041'),
    ('C000000046', '女士高跟鞋', 'C000000041'),
    ('C000000047', '男士皮帶', 'C000000041'),
    ('C000000048', '女士手錶', 'C000000041'),
    ('C000000049', '男士手錶', 'C000000041'),
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
    ('C000000073', '筆記本', 'C000000071'),
    ('C000000074', '鉛筆', 'C000000071'),
    ('C000000075', '橡皮擦', 'C000000071'),
    ('C000000076', '文件夾', 'C000000071'),
    ('C000000077', '黏土', 'C000000071'),
    ('C000000078', '彩色筆', 'C000000071'),
    ('C000000079', '尺子', 'C000000071'),
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
  categorieId CHAR(9) not null comment '商品分類編號(外來鍵)',
  productName VARCHAR(30) not null comment '商品名稱',
  productPrice INT unsigned not null comment '商品售價',
  productInfo VARCHAR(200) not null comment '商品說明',
  picture1 LONGBLOB comment '上傳圖片1',
  picture2 LONGBLOB comment '上傳圖片2',
  picture3 LONGBLOB comment '上傳圖片3',
  picture4 LONGBLOB comment '上傳圖片4',
  picture5 LONGBLOB comment '上傳圖片5',
  avgRating DECIMAL(2,1) comment '平均評價',
  firstOnShelvesDate DATE comment '首次上架日期',
  constraint FK_Product_registerSupplier foreign key (registerSupplier) references Supplier (supplierId),
  constraint FK_Product_categorieId foreign key (categorieId) references Categorie (categorieId)
)auto_increment=10000001 comment '商品資料表';

-- 商品規格
CREATE TABLE ProductSpec (
  productSpecId CHAR(11) comment '商品規格編號(主鍵)' PRIMARY KEY,
  productId INT not null comment '商品編號(外來鍵)',
  specType1 ENUM('1' ,'2' ,'3','4') comment '規格類型1：1 尺寸, 2 顏色 , 3 容量 , 4 材質',
  specInfo1 VARCHAR(10) comment '規格1詳細',
  specType2 ENUM('1' ,'2' ,'3','4') comment '規格類型2： 1 尺寸, 2 顏色 , 3 容量 , 4 材質', 
  specInfo2 VARCHAR(10) comment '規格2詳細',
  specPicture LONGBLOB comment '規格圖',
  shelvesStatus ENUM('0','1','2') not null comment '上架狀態：0 上架 , 1 永久下架 , 2 暫時下架,',
  initialStock INT unsigned not null comment '首次備貨量',
  specStock INT unsigned not null comment '庫存',
  constraint FK_Product_specProductId foreign key (productId) references Product (productId)
)comment '商品規格';

-- 商品補貨紀錄
CREATE TABLE RestockRecord (
  restockId CHAR(14) comment '補貨單號(主鍵)' PRIMARY KEY,
  productId INT not null comment '商品編號(外來鍵)',
  productSpecId CHAR(11) not null comment '商品規格編號(外來鍵)',
  restockMemberId CHAR(10) not null comment '變更人(會員編號)(外來鍵)',
  beforeRestockStock INT unsigned not null comment '補貨前庫存',
  restockQuantity INT unsigned not null comment '補貨數量',
  afterRestockStock INT unsigned not null comment '補貨後庫存',
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
  `orderCreateTime` TIMESTAMP not null,
  `orderCloseTime` TIMESTAMP,
  `subOrderStatus` ENUM('0', '1', '2','3')default(0) not null , 
  `subPaidAmount` INT unsigned not null,
  `subPointsDiscount` INT unsigned default(0) not null,
  `subCouponDiscount` INT unsigned default(0) not null,
  `grossProfit` INT unsigned not null,
  `pointsReward` INT unsigned not null,
  `grantStatus` ENUM('0', '1', '2' , '3') default(0) not null,
  `grantDate` TIMESTAMP,
  `recipient` VARCHAR(10) not null,
  `phoneNum` CHAR(12) not null,
  `deliveryAddress` VARCHAR(100) not null,
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
  `itemStatus` ENUM ('0','1','2') NOT NULL comment '商品狀態' ,
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
