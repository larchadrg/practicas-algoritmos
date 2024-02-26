module Booleano where 
data Booleano = Integer deriving Show 

instance Show where 
show x = if x % 2 == 0 then "Verdadero" else "Falso"