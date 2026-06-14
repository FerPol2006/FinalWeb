import os

base_dir = "C:/Users/herna/Desktop/IPN/Semestre_4/Desarrollo_Web/ajax/src/main/java/com/upiiz/ajax"

files_to_remove = [
    os.path.join(base_dir, "models", "Producto.java"),
    os.path.join(base_dir, "repositories", "ProductoRepository.java"),
    os.path.join(base_dir, "services", "ProductoService.java"),
    os.path.join(base_dir, "services", "ProductoServiceImpl.java"),
    os.path.join(base_dir, "controllers", "ProductoController.java")
]

for file_path in files_to_remove:
    if os.path.exists(file_path):
        os.remove(file_path)
        print(f"Removed {file_path}")
    else:
        print(f"Not found {file_path}")
