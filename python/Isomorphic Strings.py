def isIsomorphic( s,t):
    return len(set(zip(s, t))) == len(set(s)) and len(set(zip(t, s))) == len(set(t))
print(isIsomorphic("egg","add"))