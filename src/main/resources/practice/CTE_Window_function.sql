-- Total amount per customer,
-- only customers with a total amount
-- greater than 500 are selected.
with customer_total as (
    select
        customer_id,
        sum(amount) as total_amount
    from temp_orders
    group by customer_id
)
select *
from customer_total
where total_amount > 500;

-- For each order,
-- display the running_total
-- based on the order_date for each customer.

select
    order_id,
    customer_id,
    amount,
    order_date,
    sum(amount) OVER (
        partition by customer_id
        order by order_date
        rows between unbounded preceding and current row
        ) as running_total
from temp_orders;

--Rank customers by total spending using RANK()
with customer_total as(
    select customer_id,
           sum(amount) as total_amount
    from temp_orders
    group by customer_id
)
select customer_id,
       total_amount,
       rank() over (
            order by total_amount DESC
           ) as spending_rank
from customer_total;

--Find the most recent order for each customer.
with ranked_orders as(
    select *,
           rank() over(
               partition by customer_id
               order by order_date
               ) as rn
    from temp_orders
)select *
from ranked_orders
where rn =1;