expecting2 = [(2,0), (0, 2), (2, 2), (0, 0), (-2, 2), (-2, 0)]
expecting5 = [(2,0), (0, 2), (2, 2), (0, 0), (-2, 2), (-2, 0), (-2, -2), (2, -2), (0, -2)]

''''
TikTok

-2,2 ---- 0, 2 ---- 2,2
          |
          |
          |
-2,0 ---- 0,0 ---- 2,0
          |
          |
          |
-2,-2 --- 0,-2 ---- 2,-2


O(n^2) time | O(n) space
'''

def countSquares(points):
  count = 0
  storage = set(points)
  for i in range(len(points)):
    px, py = points[i]
    for j in range(i + 1, len(points)):
      x, y = points[j]
      if abs(x - px) == abs(y - py) and x != px and y != py:
        if (x, py) in storage and (px, y) in storage:
          count += 1
  return count // 2

def countSquaresAvoidDuplication(points):
  storage = set(points)
  visited_squares = set()
  for i in range(len(points)):
    px, py = points[i]
    for j in range(i + 1, len(points)):
      x, y = points[j]
      if abs(x - px) == abs(y - py) and x != px and y != py:
        if (x, py) in storage and (px, y) in storage:
          square = tuple(sorted([(px, py), (x, y), (px, y), (x, py)]))
          if square not in visited_squares:
            visited_squares.add(square)
  return len(visited_squares)


print(countSquares(expecting2))
print(countSquares(expecting5))
print(countSquaresAvoidDuplication(expecting2))
print(countSquaresAvoidDuplication(expecting5))