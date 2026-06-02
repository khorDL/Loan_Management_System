// LAZY = only load related data when you actually ask for it
@ManyToOne(fetch = FetchType.LAZY)   ✅ efficient

// EAGER = loads everything immediately, even when you don't need it
@ManyToOne(fetch = FetchType.EAGER)  ⚠️ causes performance issues at scale