

def bubble(array: list):
    n = len(array)

    # For each element in the list
    for i in range(n):
        # FOr each unsorted element
        for j in range(0, n-i-1):
            # If the element is larger
            if array[j] > array[j+1]:
                # Swap it
                array[j], array[j+1] = array[j+1], array[j]

things = [4, 3, 2, 6, 4, 7]
bubble(things)
print(things)