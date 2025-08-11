use student_management;

db.students.drop();
db.createCollection("students");

db.students.insertMany([
  {
    name: "Võ Hoàng Phúc",
    phone: "0767742630",
    email: "phuc.vo@gmail.com",
    address: "123 Đường Lê Lợi, Quận 1, TP.HCM"
  },
  {
    name: "Nguyễn Thị Minh Anh",
    phone: "0987654321",
    email: "minhanh.nguyen@gmail.com",
    address: "456 Đường Nguyễn Huệ, Quận 5, TP.HCM"
  },
  {
    name: "Trần Văn Hùng",
    phone: "0912345678",
    email: "hung.tran@gmail.com",
    address: "789 Đường Phạm Văn Đồng, Thủ Đức, TP.HCM"
  },
  {
    name: "Lê Thị Hồng Nhung",
    phone: "0938765432",
    email: "nhung.le@gmail.com",
    address: "101 Đường Trần Hưng Đạo, Quận 3, TP.HCM"
  },
  {
    name: "Phạm Quốc Đạt",
    phone: "0901234567",
    email: "dat.pham@gmail.com",
    address: "202 Đường Võ Thị Sáu, Quận 7, TP.HCM"
  }
]);
