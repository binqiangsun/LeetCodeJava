# coding: utf-8


class HeapSort:
    def __init__(self, arr):
        self.arr = arr
        self.heap_size = 0

    def build_heap_arr(self):
        self.heap_size = len(self.arr)
        for j in range(len(self.arr) / 2, -1, -1):
            self.max_heapify(j)

    def max_heapify(self, i):
        # print self.arr
        l = 2*i + 1
        r = 2*i + 2
        if l < self.heap_size and self.arr[l] > self.arr[i]:
            largest = l
        else:
            largest = i
        if r < self.heap_size and self.arr[r] > self.arr[largest]:
            largest = r
        if largest != i:
            # print "exchange: ", self.arr[largest], self.arr[i]
            self.arr[i], self.arr[largest] = self.arr[largest], self.arr[i]
            self.max_heapify(largest)

    def sort(self):
        self.build_heap_arr()
        for j in range(len(self.arr) - 1, 0, -1):
            self.arr[0], self.arr[j] = self.arr[j], self.arr[0]
            self.heap_size -= 1
            self.max_heapify(0)

    def heap_extract_max(self):
        if self.heap_size < 1:
            print "error"
            return 0
        max = self.arr[0]
        self.arr[0] = self.arr[self.heap_size-1]
        self.max_heapify(0)
        return max

if __name__ == "__main__":
    test_arr = [4, 1, 3, 2, 16, 9, 10, 14, 8, 7]
    heap_sort = HeapSort(test_arr)
    # heap_sort.build_heap_arr()
    # heap_sort.sort()
    heap_sort.build_heap_arr()
    for i in range(len(test_arr)):
        print heap_sort.heap_extract_max()
    # print heap_sort.arr

