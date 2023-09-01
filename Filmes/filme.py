import psycopg2 as db
import csv 


class Config:
    def __init__(self):
        self.config = {
            "postgres": {
                "user": "postgres",
                "password": "123",
                "host": "127.0.0.1",
                "port": "5434",
                "database": "Filmes"
            }
        }

class Connection(Config):
    def __init__(self):
       
        super().__init__()
        try:
            
            self.conn = db.connect(**self.config["postgres"])
            self.cur = self.conn.cursor()
        except Exception as e:
            print("Erro na conexão", e)
            exit(1)

    
    def __enter__(self):
        return self
     
    def __exit__(self, exc_type, exc_val, exc_tb):
        self.commit()
        self.connection.close()

    
    @property
    def connection(self):
        return self.conn

    @property
    def cursor(self):
        return self.cur

    def commit(self):
        self.connection.commit()

    
    def fetchall(self):
        return self.cursor.fetchall()

    def execute(self, sql, params=None):
        self.cursor.execute(sql, params or ())

    def query(self, sql, params=None):
        self.cursor.execute(sql, params or ())
        return self.fetchall()
    
class Filme(Connection):
    def __init__(self):
        super().__init__()
    def insert(self, *args):
        try:
            sql = "INSERT INTO Filme (titulo,dados,nota) VALUES (%s,%s,%s)"
            self.execute(sql, args)
            self.commit()
        except Exception as e:
            print("Erro ao inserir", e)

    def insert_csv(self, filename):
        try:
            data = csv.DictReader(open(filename, encoding="utf-8"))
            for row in data:
                self.insert(row["titulo"], row["dados"], row["nota"])
                print("Registro Inserido")
        except Exception as e:
            print("Erro ao inserir csv", e)
    
    
if __name__ == "__main__":
    filme = Filme()
    #filme.insert("1. Um Sonho de Liberdade","1994 2h 22m16","9.3 (2.8M)Rate")
    filme.insert_csv("data.csv")
    
