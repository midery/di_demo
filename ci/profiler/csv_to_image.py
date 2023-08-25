from numpy import genfromtxt
from PIL import Image
arr = genfromtxt('profile-out/benchmark.csv', delimiter=',')
im = Image.fromarray(arr)
im.save("benchmark.jpeg")