SELECT name as Customers
FROM Customers
LEFT JOIN Orders 
ON Customers.id = Orders.customerID
WHERE customerID IS NULL;
