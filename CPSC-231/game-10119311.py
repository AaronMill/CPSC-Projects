import random

class Game:
	delta = [[0,-1],[1,-1],[1,0],[1,1],[0,1],\
				[-1,1],[-1,0],[-1,-1]]

	def __init__(self, board, turn):
		self.board = board
		self.turn = turn
		self.moves = self.get_moves()
	def check_move(self, move, d):
#if there is a valid move, return true or false for each space
#first make the two players distinguishable 

		if self.turn == 1:
			ally = 1
			enemy = 0
		elif self.turn == 0:
			ally = 0
			enemy = 1

		#assign the different values in 'move' to seperate variables	
		row, col = move[0], move[1]

		#check for open squares 
		if self.board[row][col] != -1:
			return False


		#shift the rows and columns by delta value according to d 
		row += self.delta[d][0]
		col += self.delta[d][1]


		# check whether the move is in the grid or not
		if row == -1:
			return False
		if row == 8:
			return False
		if col == -1:
			return False
		if col == 8:
			return False
		while self.board[row][col] == enemy:


			#shift the rows and columns by the delta value according to d
			row += self.delta[d][0]
			col += self.delta[d][1]


			#check to see if the shift moved off the grid. -1 and 8 are the points that indicate that it is off the grid.  
			if row == -1:
				return False 
			if row == 8:
				return False
			if col == -1:
				return False
			if col == 8:
				return False 
			if self.board[row][col] == ally:
				return True
		else:
			return False 
			 
				
	def get_moves(self):
		self.moves = []
		#this function is similar to the one my TA showed me in tutorial 
		for i in range(8):
			for j in range(8):
				#we have a stone if previous function passes
				for d in range(8):
					if self.check_move([i,j],d):
						self.moves.append([i,j])
				
		return self.moves

	def select_move(self):
		for i in self.moves:
			if i == [0,0]:
				return i
			if i == [0,7]:
				return i 
			if i == [7,0]:
				return i
			if i == [7,7]:
				return i
		return self.get_moves()[0]

	def play_move(self, move): 
		m,n=move[0],move[1]
		for d in range(8):
			i, j = m, n
			if self.check_move(move,d):
				i, j = i+self.delta[d][0], j+self.delta[d][1]
				while self.board[i][j] == 1-self.turn:
					self.board[i][j] = self.turn
					i, j = i+self.delta[d][0], j+self.delta[d][1]
		self.board[m][n]=self.turn

	def final_result(self): 
		black, white = 0, 0   # color 0 is white
		for i in range(8):
			for j in range(8):
				if self.board[i][j] == 0: white += 1
				elif self.board[i][j] == 1: black += 1
		return white,black


		

