import shutil
import os

src = 'C:/Users/herna/Desktop/IPN/Semestre_4/Desarrollo_Web/ajax/sneat-1.0.0/assets'
dst = 'C:/Users/herna/Desktop/IPN/Semestre_4/Desarrollo_Web/ajax/src/main/resources/static/assets'

try:
    if os.path.exists(dst):
        shutil.rmtree(dst)
    shutil.copytree(src, dst)
    print("Assets copied successfully.")
except Exception as e:
    print(f"Error copying assets: {e}")
