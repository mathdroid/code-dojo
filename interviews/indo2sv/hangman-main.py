#hangman-main.py
#Muhammad Mustadi 15 Oct 2014
#Last updated: 16 Oct 2014, 16:42
#Play Hangman!

#showonstatuschange

import re
import random
import os

def draw_hangman(wrong_trial_count):
	if wrong_trial_count<=0:
		print ''
	elif wrong_trial_count==1:
		print '\n     |\n     |\n     |\n     |\n     |\n     |\n    _|___'
	elif wrong_trial_count==2:
		print '      _______\n     |/      |\n     |\n     |\n     |\n     |\n     |\n    _|___'
	elif wrong_trial_count==3:
		print '      _______\n     |/      |\n     |      (_)\n     |\n     |\n     |\n     |\n    _|___'
	elif wrong_trial_count==4:
		print '      _______\n     |/      |\n     |      (_)\n     |       |\n     |       |\n     |\n     |\n    _|___'
	elif wrong_trial_count==5:
		print '      _______\n     |/      |\n     |      (_)\n     |      \|\n     |       |\n     |\n     |\n    _|___'
	elif wrong_trial_count==6:
		print '      _______\n     |/      |\n     |      (_)\n     |      \|/\n     |       |\n     |\n     |\n    _|___'
	elif wrong_trial_count==7:
		print '      _______\n     |/      |\n     |      (_)\n     |      \|/\n     |       |\n     |      /\n     |\n    _|___'
	elif wrong_trial_count==8:
		print '      _______\n     |/      |\n     |      (_)\n     |      \|/\n     |       |\n     |      / \ \n     |\n    _|___'

print (60 * '=')
print 'Hangman-main by Muhammad Mustadi, 15 Oct 2014.'
print 'Made for Indo2SV assignment.'
print 'Let\'s play Hangman!'
print (60 * '=')

#comment4commit

#INITIALIZATION
init_done = 0
app_done = 0
while init_done!=1:
	right_answer = raw_input('The secret word is: ').lower()
	if re.match('^[\n]*$', right_answer):
		print 'Empty string. Repeat input.'
	elif re.match('^[a-zA-Z\s]*$', right_answer):
		print 'Valid string. Proceed.'
		init_done = 1
	else:
		print 'Invalid string. Repeat input.'
length_right_answer = len(right_answer)
wrong_answer = []
masked_answer = re.sub('[^ ]', '?', right_answer)
wrong_trial_max = 7
wrong_trial_count = 0
wrong_chars = ''
print 'Initialization is done. Proceed to game.'

#GAME LOOP
game_end = 0
game_lose = 0
game_win = 0
print (60 * '=')
print ('Game is starting...')
print (60 * '=')

while game_end != 1:

	#GAME ALGORITHM
	#clear screen and draw
	os.system('clear')
	print (60 * '=')
	#hanging post
	#masked string
	print masked_answer
	#life
	print 'Life: ' + str(8 - wrong_trial_count)
	print 'Wrong chars: '+ ', '.join(wrong_answer)
	draw_hangman(wrong_trial_count)

	#INPUT: char guess
	guessing_done = 0
	while guessing_done!=1:
		guess = raw_input('Guess a char in the word. (Alphabet only): ').lower()
		if re.match('^[\n]$', guess):
			print 'Empty character. Repeat input.'
		elif re.match('^[a-zA-Z]$', guess):
			print 'Valid character. Proceed.'
			guessing_done = 1
		else:
			print 'Invalid character. Repeat input.'
	#print 'NOW WE ARE CHECKING EM!'

	#CHECK EM DUBS
	i=0
	guess_right = 0
	check = ''
	while i < length_right_answer:
		if right_answer[i] == guess:
			guess_right = 1
			check = check + guess
		else:
			guess_right = guess_right
			check = check + masked_answer[i]
		i = i +1
	masked_answer = check
	if guess_right==1:
		print 'WE FOUND IT'
	else:
		print 'NOT FOUND BRO'
		if wrong_answer.count(guess)<1:
			wrong_answer.append(guess)
			wrong_trial_count = wrong_trial_count + 1


	#ENDGAME CHECKING
	if wrong_trial_count>wrong_trial_max:
		game_lose=1
		game_end=1
	if masked_answer==right_answer:
		game_win=1
		game_end=1

	#DUMMY ENDGAME
	#game_end = random.randint(0,1)
	#game_lose = random.randint(0,1)
	#game_win = 1 - game_lose

#END GAME
os.system('clear')
print (60 * '=')
print masked_answer
print 'Life: ' + str(8 - wrong_trial_count)
print 'Wrong chars: '+ ', '.join(wrong_answer)
draw_hangman(wrong_trial_count)
if game_lose == 1:
	print 'You lost the game.'
if game_win == 1:
	print 'You won the game. Congratulations!'

print 'Thanks for playing.'
print (60 * '=')
