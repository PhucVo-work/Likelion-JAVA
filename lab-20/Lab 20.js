// Lab 20 
//Thiết kế, tạo và viết câu truy vấn cơ sở dữ liệu MongoDB với các yêu cầu sau: 
// Yêu cầu 1: Tạo một collection tên là products và chèn vào 3 sản phẩm với các field: name, price, category sử dụng 
// db.products.insertMany() 
db.products.insertMany([
  {
    name: "Laptop Dell",
    price: 15000,
    category: "Electronics"
  },
  {
    name: "Coffee Maker",
    price: 1200,
    category: "Appliances"
  },
  {
    name: "Running Shoes",
    price: 1800,
    category: "Sports"
  }
])

// Yêu cầu 2: Tạo một collection orders với dữ liệu chứa các trường: orderId, customerName, orderDate, totalAmount. 
// Thêm ít nhất 2 đơn hàng. Sử dụng insertOne() hoặc insertMany().. 
db.orders.insertMany([
  {
    orderId: "ORD001",
    customerName: "Vo Hoang Phuc",
    orderDate: ISODate("2025-08-03"),
    totalAmount: 2500
  },
  {
    orderId: "ORD002",
    customerName: "Phuc Vo Hoang",
    orderDate: ISODate("2025-08-04"),
    totalAmount: 1800
  }
])
db.orders.insertOne({
  orderId: "ORD003",
  customerName: "Phuc",
  orderDate: ISODate("2025-08-04T11:30:00+07:00"),
  totalAmount: 3000
})

// Yêu cầu 3: Insert 5 documents vào collection users với các field: name, email, 
// age sử dụng insertMany() 
db.users.insertMany([
  {
    name: "Alice",
    email: "alice.wonderland@example.com",
    age: 28
  },
  {
    name: "Vo Hoang Phuc",
    email: "phuc@example.com",
    age: 22
  },
  {
    name: "Messi",
    email: "messi@example.com",
    age: 22
  },
  {
    name: "Neymar",
    email: "neymar@example.com",
    age: 29
  },
  {
    name: "Ronaldo",
    email: "david.taylor@example.com",
    age: 35
  }
])

// Yêu cầu 4: Tìm tất cả các user có độ tuổi lớn hơn 25 và chỉ hiển thị name, email 
// với find() và projection. 
db.users.find(
  { age: { $gt: 25 } },
  { name: 1, email: 1, _id: 0 }
)

// Yêu cầu 5: Cập nhật tuổi của user tên “Alice” thành 31.
db.users.updateOne(
  { name: "Alice" },
  { $set: { age: 31 } }
)

// Yêu cầu 6: Xóa tất cả user có tuổi nhỏ hơn 20. 
db.users.deleteMany(
  { age: { $lt: 20 } }
)

// Yêu cầu 7: Tìm 3 người lớn tuổi nhất trong bảng users. 
db.users.aggregate([
  { $sort: { age: -1 } },  
  { $limit: 3 }])

// Yêu cầu 8: Tìm 3 user có tuổi cao nhất và hiển thị name, age sử dụng sort() + 
limit() + projection. 
db.users.find({}, { name: 1, age: 1, _id: 0 })  
  .sort({ age: -1 })
  .limit(3)

// Yêu cầu 9: Thực hiện truy vấn aggregation để đếm số lượng user theo từng độ 
// tuổi với $group. 
db.users.aggregate([
  {
    $group: {
      _id: "$age",           
      count: { $sum: 1 }     
    }
  }
])

// Yêu cầu 10: Tính tuổi trung bình của user có tuổi từ 25 trở lên bằng aggregation 
// pipeline (kết hợp $match và $group) 
db.users.aggregate([
  {
    $match: { age: { $gt: 25 } }  
  },
  {
    $group: {
      _id: null,                    
      averageAge: { $avg: "$age" }  
    }
  }
])
 