
Laboratorio Esercitazione 1
==================
Riassunto e analisi delle funzioni numpy
----------------------


```python
from numpy  import *
a = arange(15).reshape(3, 5)
a

```




    array([[ 0,  1,  2,  3,  4],
           [ 5,  6,  7,  8,  9],
           [10, 11, 12, 13, 14]])



Creata matrice da 3 righe e 5 colonne


```python
a.ndim

```




    2



dimensioni della matrice


```python
a.size

```




    15



numero elementi della matrice


```python
b = array( [ (1.5,2,3), (4,5,6) ] )
b

```




    array([[ 1.5,  2. ,  3. ],
           [ 4. ,  5. ,  6. ]])



array trasforma n sequenze in array n-dimensionali


```python
 A = array( [[1,1],[0,1]] )
B = array( [[2,0],[3,4]] )
A*B


```




    array([[2, 0],
           [0, 4]])




```python
dot(A,B)

```




    array([[5, 4],
           [3, 4]])



arange zeros e one so funzioni utili che consentono di generare array desiderati senza inserire manualmente i valori.
rispettivamente zeros e one tutti 0 e 1, arange invece indicando intervallo e passo.


```python
import numpy as np
b=np.arange(12).reshape(3,4)
b
b.min(axis=1)

```




    array([0, 4, 8])



attraverso la funzione axis è possibile scegliere in base a quale asse applicare una determianta operazione

sugli arrray sono presenti altre funzioni di interesse ma che già abbiamo studiato nella slide learn x in y in particolar modo quelle relative all'accesso su array 



```python
from numpy import *

```


```python
punti=random.rand(100,2)
```


```python
punti

```




    array([[ 0.42300084,  0.41678629],
           [ 0.26105348,  0.87990356],
           [ 0.06527506,  0.59910716],
           [ 0.555986  ,  0.72264708],
           [ 0.15194172,  0.30468254],
           [ 0.93774678,  0.79638365],
           [ 0.59186759,  0.47607993],
           [ 0.37957217,  0.75624355],
           [ 0.55249329,  0.22755506],
           [ 0.9000241 ,  0.37875888],
           [ 0.3130707 ,  0.36016831],
           [ 0.93843233,  0.47092741],
           [ 0.41562182,  0.40898116],
           [ 0.13373347,  0.25242172],
           [ 0.09011352,  0.28354074],
           [ 0.50012132,  0.26042328],
           [ 0.35560574,  0.95294503],
           [ 0.51129286,  0.84417476],
           [ 0.36324654,  0.76847267],
           [ 0.8254599 ,  0.55543217],
           [ 0.36782018,  0.52864461],
           [ 0.48789686,  0.98508543],
           [ 0.71158579,  0.31879774],
           [ 0.14870438,  0.88067384],
           [ 0.07344479,  0.65433162],
           [ 0.09327947,  0.10327254],
           [ 0.38429555,  0.43243214],
           [ 0.51786471,  0.46103516],
           [ 0.39260268,  0.66309829],
           [ 0.96846445,  0.16943013],
           [ 0.91694179,  0.73374731],
           [ 0.26100158,  0.10169842],
           [ 0.74938991,  0.67559144],
           [ 0.43400615,  0.8344122 ],
           [ 0.88265224,  0.80150342],
           [ 0.19733225,  0.93744355],
           [ 0.14867424,  0.98053814],
           [ 0.30358219,  0.88031032],
           [ 0.52610022,  0.03834761],
           [ 0.2811505 ,  0.47170289],
           [ 0.07938455,  0.5809199 ],
           [ 0.8088384 ,  0.43043154],
           [ 0.30294411,  0.51105192],
           [ 0.14574765,  0.97800252],
           [ 0.60568905,  0.00341819],
           [ 0.73021789,  0.99343297],
           [ 0.11733756,  0.75712313],
           [ 0.6209094 ,  0.76000811],
           [ 0.52933443,  0.81985201],
           [ 0.99896181,  0.06510455],
           [ 0.78178703,  0.28301766],
           [ 0.60047825,  0.50959689],
           [ 0.65517295,  0.36935922],
           [ 0.53886309,  0.42672483],
           [ 0.58539361,  0.42631568],
           [ 0.85632395,  0.65428845],
           [ 0.80640048,  0.92992653],
           [ 0.93257195,  0.96258936],
           [ 0.05191864,  0.26142541],
           [ 0.54580212,  0.60578767],
           [ 0.39932295,  0.02391706],
           [ 0.66967605,  0.49720812],
           [ 0.43091942,  0.88699115],
           [ 0.84868318,  0.28064339],
           [ 0.38754876,  0.59199196],
           [ 0.97232059,  0.15244495],
           [ 0.42559957,  0.13707943],
           [ 0.71786638,  0.32088365],
           [ 0.33998607,  0.91983771],
           [ 0.99117346,  0.76791361],
           [ 0.19207393,  0.09592269],
           [ 0.55169084,  0.48713736],
           [ 0.41834712,  0.39121268],
           [ 0.61956942,  0.68133903],
           [ 0.12869568,  0.23634994],
           [ 0.38600656,  0.13962431],
           [ 0.02140987,  0.34157937],
           [ 0.1862832 ,  0.9572946 ],
           [ 0.0219869 ,  0.23116956],
           [ 0.81908218,  0.0399553 ],
           [ 0.13027081,  0.8154262 ],
           [ 0.83136706,  0.69690817],
           [ 0.94774203,  0.69473743],
           [ 0.0881763 ,  0.26394974],
           [ 0.18909016,  0.97355402],
           [ 0.78141038,  0.70373545],
           [ 0.40567898,  0.14619774],
           [ 0.87023334,  0.81798926],
           [ 0.39431668,  0.02288903],
           [ 0.82775781,  0.20617443],
           [ 0.60082999,  0.9066102 ],
           [ 0.96437796,  0.6202025 ],
           [ 0.76059282,  0.3590052 ],
           [ 0.15476659,  0.14171739],
           [ 0.19272052,  0.85433772],
           [ 0.66290038,  0.37945794],
           [ 0.81133535,  0.13057391],
           [ 0.82272875,  0.6185559 ],
           [ 0.07463126,  0.10694318],
           [ 0.05949444,  0.89819919]])




```python
from pyplasm import *
```

    Evaluating fenvs.py..
    ...fenvs.py imported in 0.011543 seconds



```python
VIEW(STRUCT([MK(p) for p in punti]))
```




    <pyplasm.xgepy.Hpc; proxy of <Swig Object of type 'std::shared_ptr< Hpc > *' at 0xadff64b8> >



![punti piazza](punti.png)



```python
def larExtrude1(model,pattern):
    """ Simplicial model extrusion in accord with a 1D pattern """
    V, FV = model
    d, m = len(FV[0]), len(pattern)
    coords = list(cumsum([0]+(AA(ABS)(pattern))))
    offset, outcells, rangelimit = len(V), [], d*m
    for cell in FV:
        tube = [v + k*offset for k in range(m+1) for v in cell]
        cellTube = [tube[k:k+d+1] for k in range(rangelimit)]
        outcells += [reshape(cellTube, newshape=(m,d,d+1)).tolist()]
    outcells = AA(CAT)(TRANS(outcells))
    cellGroups = [group for k,group in enumerate(outcells) if pattern[k]>0]
    outVertices = [v+[z] for z in coords for v in V]
    outModel = outVertices, CAT(cellGroups)
    return outModel
```


```python
model = [[0,0],[1,0],[0,1]], [[0,1,2]]
pattern = [1]
```


```python
from larlib import *
```

    /usr/local/lib/python2.7/dist-packages/larlib/larstruct.py:233: FutureWarning: comparison to `None` will result in an elementwise object comparison in the future.
      self.body = [item for item in data if item != None]



```python
pattern = [1]*10
VIEW(STRUCT(MKPOLS((larExtrude1(model,pattern)))))
```




    <pyplasm.xgepy.Hpc; proxy of <Swig Object of type 'std::shared_ptr< Hpc > *' at 0xabfdcd88> >



![esempio 1](p1.png)


```python
V = [[0,0],[1,0],[2,0],[0,1],[1,1],[2,1],[0,2],[1,2],[2,2]]
FV = [[0,1,3],[1,2,4],[2,4,5],[3,4,6],[4,6,7],[5,7,8]]
model = larExtrude1((V,FV),4*[1,2,-3])
VIEW(EXPLODE(1,1,1.2)(MKPOLS(model)))
```




    <pyplasm.xgepy.Hpc; proxy of <Swig Object of type 'std::shared_ptr< Hpc > *' at 0xac00a7a0> >



![esempio 2](p2.png)


```python
model = larExtrude1( VOID, 10*[1] )
VIEW(EXPLODE(1.5,1.5,1.5)(MKPOLS(model)))
model = larExtrude1( model, 10*[1] )
VIEW(EXPLODE(1.5,1.5,1.5)(MKPOLS(model)))
model = larExtrude1( model, 10*[1] )
VIEW(EXPLODE(1.5,1.5,1.5)(MKPOLS(model)))
```




    <pyplasm.xgepy.Hpc; proxy of <Swig Object of type 'std::shared_ptr< Hpc > *' at 0xacd5e848> >



![esempio 3](p3.png)


```python
model = larExtrude1( VOID, 13*[1,-1] )
VIEW(EXPLODE(2,1.5,2)(MKPOLS(model)))
model = larExtrude1( model, 13*[1,2] )
VIEW(EXPLODE(1.5,3,1.5)(MKPOLS(model)))
```




    <pyplasm.xgepy.Hpc; proxy of <Swig Object of type 'std::shared_ptr< Hpc > *' at 0xab9c1e60> >



![esempio 4](p4.png)


```python

```
