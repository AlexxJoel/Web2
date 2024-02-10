export const Patterns = {
  letter: (value) => /^[a-zA-ZñÑÀ-ÿ\sñ]{1,}$/g.test(value),
  cp: (value) => /^[0-9]{5}$/g.test(value),
  notSpecialCharacters: (value) => /^[^._\-+*\{\}\(\)\[\]\/\\]+$/g.test(value),
  numbers: (value) => /^[0-9]{1,}$/g.test(value),
  birthdate: (value) => /^([0-9]{4})\-([0-9]{2})\-([0-9]{2})$/g.test(value),
  email: (value) =>    /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/g.test(value),
  phone: (value) => /^[0-9]{10}$/g.test(value),
};
