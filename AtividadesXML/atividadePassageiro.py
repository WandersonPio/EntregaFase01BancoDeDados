import xml.etree.ElementTree as ET

tree = ET.parse("passageiros.xml")
root = tree.getroot()
quantidade = 0

for passageiro in root.findall("passageiro"):
    nome = passageiro.find("nome").text
    origem = passageiro.find("origem").text
    destino = passageiro.find("destino").text
    quantidade = quantidade + 1
    print(f"Passageiro: {nome}, Origem: {origem} e Destino: {destino}")
print(f"Total de passageiros: {quantidade} pessoas")