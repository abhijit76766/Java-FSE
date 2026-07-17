console.log('Welcome to the Community Portal');
window.addEventListener('load', () => alert('Community Portal loaded'));

class CommunityEvent {
  constructor(id, name, date, category, location, seats) {
    this.id = id;
    this.name = name;
    this.date = new Date(date);
    this.category = category;
    this.location = location;
    this.seats = seats;
  }

  checkAvailability() {
    return this.date >= new Date() && this.seats > 0;
  }
}

const featuredEventName = 'Music Night';
const featuredEventDate = '2026-08-01';
let availableSeats = 30;
console.log(`${featuredEventName} happens on ${featuredEventDate}. Seats: ${availableSeats}`);

let events = [
  new CommunityEvent(1, 'Music Night', '2026-08-01', 'Music', 'New York', 25),
  new CommunityEvent(2, 'Baking Workshop', '2026-08-04', 'Workshop', 'Chicago', 12),
  new CommunityEvent(3, 'City Marathon', '2026-09-12', 'Sports', 'Los Angeles', 0),
  new CommunityEvent(4, 'Past Meetup', '2024-01-10', 'Workshop', 'New York', 10)
];

function addEvent(event) {
  events.push(event);
  renderEvents(events);
  fillEventOptions();
}

function createCategoryRegistrationTracker(category) {
  let total = 0;
  return function register() {
    total += 1;
    console.log(`${category} registrations: ${total}`);
    return total;
  };
}

const trackMusicRegistration = createCategoryRegistrationTracker('Music');

function filterEventsByCategory(category, callback = event => event.checkAvailability()) {
  const clonedEvents = [...events];
  return clonedEvents.filter(event => (category === 'all' || event.category === category) && callback(event));
}

function registerUser(eventId) {
  try {
    const event = events.find(item => item.id === Number(eventId));
    if (!event) throw new Error('Event not found');
    if (!event.checkAvailability()) throw new Error('Event is full or already completed');
    event.seats--;
    availableSeats--;
    if (event.category === 'Music') trackMusicRegistration();
    renderEvents(filterEventsByCategory(document.querySelector('#categoryFilter').value));
    return `Registered for ${event.name}`;
  } catch (error) {
    return error.message;
  }
}

function renderEvents(eventList) {
  const container = document.querySelector('#eventsContainer');
  container.innerHTML = '';
  eventList.forEach(event => {
    const { name, category, location, seats } = event;
    const card = document.createElement('article');
    card.className = 'event-card';
    card.innerHTML = `<h2>${name}</h2><p>${category} in ${location}</p><p>Seats: ${seats}</p><button data-id="${event.id}">Register</button>`;
    card.querySelector('button').onclick = () => {
      document.querySelector('#formMessage').textContent = registerUser(event.id);
    };
    container.appendChild(card);
  });
}

function fillEventOptions() {
  const select = document.querySelector('[name="eventId"]');
  select.innerHTML = events
    .filter(event => event.checkAvailability())
    .map(event => `<option value="${event.id}">${event.name}</option>`)
    .join('');
}

function loadEventsWithThen() {
  return fetch('events.json')
    .then(response => response.json())
    .then(data => data.map(item => new CommunityEvent(item.id, item.name, item.date, item.category, item.location, item.seats)))
    .catch(error => {
      console.warn('Using built-in events because fetch failed:', error.message);
      return events;
    });
}

async function loadEventsAsync() {
  const spinner = document.querySelector('#spinner');
  spinner.style.display = 'block';
  const loadedEvents = await loadEventsWithThen();
  spinner.style.display = 'none';
  events = loadedEvents;
  renderEvents(filterEventsByCategory('all'));
  fillEventOptions();
}

document.querySelector('#categoryFilter').onchange = event => {
  renderEvents(filterEventsByCategory(event.target.value));
};

document.querySelector('#searchBox').addEventListener('keydown', event => {
  setTimeout(() => {
    const search = event.target.value.toLowerCase();
    renderEvents(events.filter(item => item.name.toLowerCase().includes(search)));
  });
});

document.querySelector('#registrationForm').addEventListener('submit', event => {
  event.preventDefault();
  const { name, email, eventId } = event.target.elements;
  const message = document.querySelector('#formMessage');
  console.log('Submitting registration', { name: name.value, email: email.value, eventId: eventId.value });
  if (!name.value.trim() || !email.value.includes('@')) {
    message.className = 'error';
    message.textContent = 'Enter a valid name and email.';
    return;
  }
  setTimeout(async () => {
    try {
      await fetch('https://jsonplaceholder.typicode.com/posts', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name: name.value, email: email.value, eventId: eventId.value })
      });
      message.className = 'success';
      message.textContent = registerUser(eventId.value);
    } catch (error) {
      message.className = 'error';
      message.textContent = 'Registration service unavailable.';
    }
  }, 800);
});

if (window.jQuery) {
  $('#registerBtn').click(() => $('.event-card').fadeOut(100).fadeIn(200));
  console.log('Framework note: React or Vue helps manage large UI state with reusable components.');
}

console.log(Object.entries(events[0]));
console.log(events.filter(event => event.category === 'Music'));
console.log(events.map(event => `${event.category} on ${event.name}`));

loadEventsAsync();
