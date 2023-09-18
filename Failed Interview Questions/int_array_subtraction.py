'''
MSFT

'''

def subtract(n1, n2):
  sub = []
  i, j, c = len(n1) - 1, len(n2) - 1, 0
  while i >= 0 or j >= 0:
    a = 0 if i < 0 else n1[i]
    b = 0 if j < 0 else n2[j]
    sum = a - b + c
    if sum < 0:
      c = -1
      sum += 10
    else:
      c = 0
    sub.append(sum)
    i -= 1
    j -= 1

  # Swap n1 and n2, then do it again.
  if c < 0:
    tmp = subtract(n2, n1)
    tmp[0] *= -1
    return tmp

  sub = sub[::-1]

  # Remove leading zeros
  start = 0
  while start < len(sub) - 1 and sub[start] == 0:
    start += 1
  return sub[start:]


n1, n2 = [4, 4, 4], [6, 7, 8]
print(subtract(n1, n2))