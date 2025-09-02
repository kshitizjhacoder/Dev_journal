# 🐍 Python + ML Cheatsheet

## 1️⃣ Python Basics
```python
# List comprehension
squares = [x**2 for x in range(10)]

# Lambda
add = lambda a, b: a+b

# Enumerate
for i, val in enumerate(['a','b']):
    print(i, val)

# Zip
names = ['a','b']; scores = [90, 80]
list(zip(names, scores))

# Dict comprehension
squares = {x: x**2 for x in range(5)}


import numpy as np

arr = np.array([1,2,3])
arr.shape, arr.ndim, arr.size

# Create arrays
np.zeros((2,2)), np.ones((2,2)), np.eye(3)
np.arange(0,10,2), np.linspace(0,1,5)

# Indexing
arr[0], arr[-1], arr[1:3]

# Operations
np.mean(arr), np.std(arr), np.sum(arr)
np.dot([1,2],[3,4])   # dot product
arr.reshape(3,1)


import pandas as pd

df = pd.read_csv("file.csv")

# Quick info
df.head(), df.info(), df.describe()

# Select
df['col'], df[['c1','c2']]
df.iloc[0:5, 1:3], df.loc[df['age']>30]

# Cleaning
df.dropna(), df.fillna(0)
df.drop_duplicates()

# Grouping
df.groupby('col').mean()
df['col'].value_counts()

# Merging
pd.merge(df1, df2, on='id', how='inner')


import matplotlib.pyplot as plt

plt.plot([1,2,3],[4,5,6], label="line")
plt.scatter([1,2,3],[4,5,6])
plt.bar(['a','b'], [10,20])
plt.hist([1,2,2,3,3,3,4])
plt.legend(); plt.xlabel("x"); plt.ylabel("y")
plt.show()


import seaborn as sns

sns.heatmap(df.corr(), annot=True)
sns.pairplot(df, hue="target")
sns.boxplot(x="col", y="val", data=df)
sns.histplot(df['col'], bins=20)


from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import StandardScaler

# Train/test split
X_train, X_test, y_train, y_test = train_test_split(X,y,test_size=0.2)

# Standardization
scaler = StandardScaler()
X_train = scaler.fit_transform(X_train)
X_test = scaler.transform(X_test)

# Linear Regression
model = LinearRegression()
model.fit(X_train, y_train)
pred = model.predict(X_test)
model.score(X_test, y_test)
