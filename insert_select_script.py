import random
from datetime import datetime, timedelta
import time
import psycopg2
import keyboard

# Configurações de simulação
NUM_INSERTS = 10  # Número de inserções a serem simuladas
NUM_QUERIES = 10  # Número de consultas a serem simuladas
CONNECTION = "postgres://tsdbadmin:yhsbhq5vduxnztut@vdnzby4nki.s1yliudf4q.tsdb.cloud.timescale.com:37674/tsdb?sslmode=require"

# Função para gerar dados aleatórios
def generate_random_data():
    vendorid = random.randint(1, 2)
    pickup_datetime = datetime.now() - timedelta(days=random.randint(0, 365))
    dropoff_datetime = pickup_datetime + timedelta(minutes=random.randint(1, 60))
    passenger_count = random.randint(1, 4)
    trip_distance = random.uniform(0.5, 10.0)
    ratecodeid = random.uniform(1, 6)
    store_and_fwd_flag = random.choice(['Y', 'N'])
    pulocationid = random.randint(1, 100)
    dolocationid = random.randint(1, 100)
    payment_type = random.randint(1, 5)
    fare_amount = random.uniform(5.0, 50.0)
    extra = random.uniform(0.0, 5.0)
    mta_tax = random.uniform(0.0, 2.0)
    tip_amount = random.uniform(0.0, 10.0)
    tolls_amount = random.uniform(0.0, 5.0)
    improvement_surcharge = random.uniform(0.0, 1.0)
    total_amount = fare_amount + extra + mta_tax + tip_amount + tolls_amount + improvement_surcharge
    congestion_surcharge = random.uniform(0.0, 2.75)
    airport_fee = random.uniform(0.0, 5.0)

    return (vendorid, pickup_datetime, dropoff_datetime, passenger_count, trip_distance,
            ratecodeid, store_and_fwd_flag, pulocationid, dolocationid, payment_type,
            fare_amount, extra, mta_tax, tip_amount, tolls_amount, improvement_surcharge,
            total_amount, congestion_surcharge, airport_fee)

# Função para inserir dados
def insert_data(conn, cur):
    for _ in range(NUM_INSERTS):
        data = generate_random_data()
        insert_query = '''
            INSERT INTO trip_data (vendorid, tpep_pickup_datetime, tpep_dropoff_datetime, passenger_count,
                                   trip_distance, ratecodeid, store_and_fwd_flag, pulocationid, dolocationid,
                                   payment_type, fare_amount, extra, mta_tax, tip_amount, tolls_amount,
                                   improvement_surcharge, total_amount, congestion_surcharge, Airport_fee)
            VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        '''
        cur.execute(insert_query, data)
        conn.commit()
    print('Inserções feitas')

# Função para consultar dados
def query_data(cur):
    for _ in range(NUM_QUERIES):
        pickup_datetime = datetime.now() - timedelta(days=random.randint(0, 365))
        query = '''
            SELECT * FROM trip_data
            WHERE tpep_pickup_datetime < %s
            LIMIT 10
        '''
        cur.execute(query, (pickup_datetime,))
        #result = cur.fetchall()
        #return result
    print('Consultas feitas')

def main():
    with psycopg2.connect(CONNECTION) as conn:
        cursor = conn.cursor()

    while True:
        insert_data(conn, cursor)
        query_data(cursor)
        time.sleep(1)

        if keyboard.is_pressed('s'):
            break

    conn.close()
    cursor.close()

if __name__ == "__main__":
    main()