DELETE FROM users;
DELETE FROM procedures;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password, role) VALUES
  ('Admin', 'admin@gmail.com', 'admin', 'ROLE_ADMIN');        --100000

INSERT INTO procedures (name, specialist, price, date, room) VALUES
  ('Electrocardiogram', 'Ivanov Petr', 1000, 'Monday, 12:00', 124),
  ('ЭКГ', 'Иванов Петр Алексеевич', 1000, 'Понедельник, 12:00', 124),
  ('Ultrasound', 'Borcov Andrey', 800, 'Friday, 16:30', 203),
  ('Узи', 'Борцов Андрей Александрович', 800, 'Пятница, 16:30', 203),
  ('Light therapy', 'Suhorukov Petr', 240, 'Tuesday, 12:30', 231),
  ('Светотерапия', 'Сухоруков Петр Владимирович', 240, 'Вторник, 12:30', 231),
  ('Electrostimulation', 'Novodelov Sergey', 400, 'Wednesday, 16:00', 111),
  ('Электростимуляция', 'Новоделов Сергей Григорьевич', 400, 'Среда, 16:00', 111),
  ('Physiotherapy', 'Andreev Alexey', 800, 'Thursday, 11:00', 321),
  ('ЛФК', 'Андреев Алексей Иванович', 800, 'Четверг, 11:00', 321),
  ('Lokomat', 'Boiko Vladimir', 2000.20, 'Friday, 13:00', 442),
  ('Локомат', 'Бойко Владимир Сергеевич', 2000.20, 'Пятница, 13:00', 442),
  ('Massage', 'Sidorov Andrey', 800, 'Monday, 12:30', 311),
  ('Массаж', 'Сидоров Андрей Петрович', 800, 'Понедельник, 12:30', 311),
  ('Magnetotherapy', 'Subbotin Sergey', 500, 'Tuesday, 11:20', 202),
  ('Магнитотерапия', 'Субботин Сергей Владимирович', 500, 'Вторник, 11:20', 202),
  ('Laser therapy', 'Zemlyanikin Vladimir', 600, 'Wednesday, 13:10', 304),
  ('Лазеротерапия', 'Земляникин Владимир Артемович', 600, 'Среда, 13:10', 304),
  ('Pressure chamber', 'Pogodin Igor', 800, 'Thursday, 15:00', 501),
  ('Барокамера', 'Погодин Игорь Петрович', 800, 'Четверг, 15:00', 501);
