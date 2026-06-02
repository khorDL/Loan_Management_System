# Soft Skill of the Week — Problem Finding Mindset
"Before you write code, write the problem."

Every time you start a feature, ask yourself:

What is the exact input?
What is the exact expected output?
What can go wrong in between?

Soft Skill — How Enterprise Devs Think About Structure

# In unstructured code, you ask: "Where do I put this?"
In clean architecture, you ask: "What is this code's ONE job?"

Controller = only receives request, calls service, returns response
Service = only contains business logic
Repository = only talks to database
Model = only describes data shape

