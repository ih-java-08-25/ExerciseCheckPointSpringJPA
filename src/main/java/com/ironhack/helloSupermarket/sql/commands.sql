USE Inventory;

# changing storage space to fit UUID
DESCRIBE item;
ALTER TABLE item MODIFY category VARCHAR(100);
#
INSERT INTO item (name, category, price, stock) VALUES
                                                    ('Apple', 'PRODUCE', 0.99, 50),
                                                    ('Banana', 'PRODUCE', 0.59, 100),
                                                    ('Milk', 'DIARY', 1.49, 40),
                                                    ('Cheddar Cheese', 'DIARY', 3.99, 30),
                                                    ('Bread', 'BAKERY', 2.49, 25),
                                                    ('Croissant', 'BAKERY', 1.99, 20),
                                                    ('Orange Juice', 'BEVERAGES', 2.99, 35),
                                                    ('Coffee', 'BEVERAGES', 5.99, 15),
                                                    ('Pasta', 'PANTRY', 1.79, 60),
                                                    ('Rice', 'PANTRY', 2.49, 50),
                                                    ('Frozen Pizza', 'FROZEN', 4.99, 20),
                                                    ('Ice Cream', 'FROZEN', 3.49, 25),
                                                    ('Yogurt', 'DIARY', 0.99, 40),
                                                    ('Bagel', 'BAKERY', 1.29, 30),
                                                    ('Lettuce', 'PRODUCE', 1.19, 35),
                                                    ('Tomato', 'PRODUCE', 0.89, 50),
                                                    ('Soda', 'BEVERAGES', 1.49, 60),
                                                    ('Cereal', 'PANTRY', 3.99, 20),
                                                    ('Frozen Vegetables', 'FROZEN', 2.99, 40),
                                                    ('Butter', 'DIARY', 2.79, 25);


